
def gridTraveler(m: int, n: int, result: int = 0) -> int:
    if m == 0 or n == 0:
        return 0

    if m == 1 and n == 1:
        return 1

    if (m > 0):
        result += gridTraveler(m-1, n)

    if (n > 0):
        result += gridTraveler(m, n-1)

    return result

if __name__ == '__main__':
    print(gridTraveler(1, 1)) # 1
    print(gridTraveler(2, 3)) # 3
    print(gridTraveler(3, 2)) # 3
    print(gridTraveler(3, 3)) # 6
    print(gridTraveler(18, 18)) # 233606220 # FIXME: takes too long without optimization