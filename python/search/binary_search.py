
from array import array


def binary_search(arr: array, val: int, low: int, high: int):
    if low > high:
        return -1
    
    mid = int(low + (high-low)/2)

    if arr[mid] == val:
        return mid

    return binary_search(arr, val, low, mid-1) if val < arr[mid] else binary_search(arr, val, mid+1, high)

if __name__ == '__main__':
    print(binary_search([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5, 0, 9))
    print(binary_search([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 1, 0, 9))
    print(binary_search([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 10, 0, 9))
    print(binary_search([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 11, 0, 9))