def donustur(n):
    if n >=90:
        return 4
    elif n >=80:
        return 3
    elif n >=70:
        return 2
    elif n >=60:
        return 1
    else:
        return 0

def main():
  try:
    n = int(input()) #öğrenci sayısı için

    if n == 0:
        print("Error")
        return
    ogrenciler = {}

    for _ in range(n):
        ad, notu = input("").split() #öğrenci adı için
        ogrenciler[ad] = int(notu)

    ogrenciler_4 = {ad: donustur(notu) for ad, notu in ogrenciler.items()}

    max_ogrenci = max(ogrenciler, key=ogrenciler.get)
    max_not_yuz = ogrenciler[max_ogrenci]
    max_not_dort = ogrenciler_4[max_ogrenci]

    ortalama_yuz = sum(ogrenciler.values()) / n
    ortalama_dort = donustur(ortalama_yuz)

    print(f"{max_ogrenci}: {max_not_yuz} {max_not_dort}")
    print(f"AVG: {int(ortalama_yuz)} {int(ortalama_dort)}")

    for ad, notu in ogrenciler_4.items():
        print(f"{ad}: {notu}")
  except ValueError:
      print("Error")
main()