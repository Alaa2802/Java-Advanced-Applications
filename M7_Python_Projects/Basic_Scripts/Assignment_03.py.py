def cift_sayilar(n):
    return {x for x in range(1, n+1) if x % 2 == 0}

def ucun_katlari(n):
    return {x for x in range(1, n+1) if x % 3 == 0}

n = int(input())
cift_kume = cift_sayilar(n)
ucun_katlari_kume= ucun_katlari(n)

union_set = cift_kume.union(ucun_katlari_kume)
print(union_set)

intersection_set = cift_kume.intersection(ucun_katlari_kume)
print(intersection_set)

difference_set = cift_kume.difference(ucun_katlari_kume)
print(difference_set)