
def gridTraveler(m: int, n: int, result: int = 0, cache: dict = {}) -> int:

    def key(x: int, y: int) -> str:
        return str(x) + str(y) if str(x) > str(y) else str(y) + str(x)

    cache_key = key(m, n)
    cached = cache[cache_key] if cache_key in cache else None
    if cached:
        return cached

    if m == 0 or n == 0:
        return 0

    if m == 1 and n == 1:
        return 1

    cache[key(m-1, n)] = gridTraveler(m-1, n, cache)
    cache[key(m, n-1)] = gridTraveler(m, n-1, cache)
    return cache[key(m-1, n)] + cache[key(m, n-1)]

if __name__ == '__main__':
    print(gridTraveler(1, 1)) # 1
    print(gridTraveler(2, 3)) # 3
    print(gridTraveler(3, 2)) # 3
    print(gridTraveler(3, 3)) # 6
    print(gridTraveler(18, 18)) # 2333606220 # FIXME: takes too long without optimization