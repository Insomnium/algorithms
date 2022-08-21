import array


def mergeSort(a: array, size: int) -> None:
    if (size <= 1):
        return

    mid = int(size / 2)
    l = a[:mid]
    r = a[mid:]

    mergeSort(l, len(l))
    mergeSort(r, len(r))

    merge(a, l, r, len(l), len(r))

def merge(a: array, left: array, right: array, l_size: int, r_size: int) -> None:
    l = r = i = 0
    while l < l_size and r < r_size:
        if left[l] < right[r]:
            a[i] = left[l]
            l += 1
        else:
            a[i] = right[r]
            r += 1
        i += 1

    while l < l_size:
        a[i] = left[l]
        i += 1
        l += 1

    while r < r_size:
        a[i] = right[r]
        i += 1
        r += 1
    

if __name__ == '__main__':
    arr: array = [1, 9, 2, 8, 3, 7, 4, 6, 5, 0, 10]
    mergeSort(arr, len(arr))
    print(arr)