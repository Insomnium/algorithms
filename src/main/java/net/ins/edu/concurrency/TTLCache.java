package net.ins.edu.concurrency;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;

public class TTLCache<K, V> {

    private final Map<K, Entry<V>> store = new ConcurrentHashMap<>();

    public TTLCache(int cleanupDelay, TimeUnit cleanupDelayTimeUnit, long ttlMillis) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(r -> new Thread(r) {{
            setDaemon(true);
        }});
        executorService.scheduleAtFixedRate(new Cleanup(ttlMillis), 0L, cleanupDelay, cleanupDelayTimeUnit);
    }

    public TTLCache(long ttlMillis) {
        this(1, TimeUnit.SECONDS, ttlMillis);
    }

    private class Cleanup implements Runnable {

        private final long ttlMillis;

        private Cleanup(long ttlMillis) {
            this.ttlMillis = ttlMillis;
        }

        @Override
        public void run() {
            store.entrySet().removeIf(item -> System.currentTimeMillis() - item.getValue().timestamp >= this.ttlMillis);
        }
    }

    public V put(K key, V value) {
        return Optional.ofNullable(store.put(key, new Entry<>(value))).map(it -> it.value).orElse(null);
    }

    public V get(K key) {
        return store.getOrDefault(key, new Entry<>(null)).value;
    }

    public boolean containsKey(K key) {
        return store.containsKey(key);
    }

    private class Entry<V> {
        private final V value;
        private final long timestamp;

        public Entry(V value) {
            this.value = value;
            this.timestamp = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var cache = new TTLCache<String, Integer>(2000);
        System.out.println(cache.put("123", 123));
        System.out.println(cache.put("123", 321));
        Thread.sleep(1000);
        System.out.println(cache.containsKey("123"));
        Thread.sleep(2100);
        System.out.println(cache.containsKey("123"));
    }
}
