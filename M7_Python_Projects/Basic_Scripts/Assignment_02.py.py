def main():
    try:
        giris = input().split()

        if len(giris) != 5:
            print("Error")
            return

        numaralar = []
        for item in giris:
            try:
                num = float(item)
                numaralar.append(num)
            except ValueError:
                print("Error")
                return
        #demete dönüştür
        numaralar_tuple = tuple(numaralar)

        max_deger = int(max(numaralar_tuple))
        min_deger = int(min(numaralar_tuple))

        print(int(max_deger))
        print(int(min_deger))
    except Exception as e:
        #başka bir beklemeyen hata çıkarsa
        print("Error")

main()