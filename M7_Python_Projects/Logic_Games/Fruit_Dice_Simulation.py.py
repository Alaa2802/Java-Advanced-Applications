import random

# Meyve listesi
fruits = ["elma", "muz", "kiraz"]

# Zar ve meyve atma fonksiyonu
def roll_dice_and_pick_fruit():
    dice = random.randint(1, 6)
    fruit = random.choice(fruits)
    return dice, fruit

# Puan hesaplama fonksiyonu
def calculate_score(dice, fruit):
    if dice == 6 and fruit == "kiraz":
        return 10
    elif fruit == "muz":
        return 6
    else:
        return dice

# Oyuncunun turunu oynama fonksiyonu
def play_turn(player_name, round_num):
    print(f"\n{player_name} - {round_num}. Tur")
    dice, fruit = roll_dice_and_pick_fruit()
    score = calculate_score(dice, fruit)
    print(f"Zar: {dice}  | Meyve: {fruit}  | Kazanılan Puan: {score}")
    return score

# Oyun ana fonksiyonu
def play_game():
    print(" Meyve Zar Yarışı Oyununa Hoş Geldiniz!")

    player1 = input(" 1. Oyuncunun adı: ")
    player2 = input(" 2. Oyuncunun adı: ")

    rounds = 3
    total_score1 = 0
    total_score2 = 0

    for round_num in range(1, rounds + 1):
        total_score1 += play_turn(player1, round_num)
        total_score2 += play_turn(player2, round_num)

    # Sonuçları göster
    print("\n Oyun Bitti! Sonuçlar:")
    print(f"{player1} Toplam Puan: {total_score1}")
    print(f"{player2} Toplam Puan: {total_score2}")

    if total_score1 > total_score2:
        print(f" Kazanan: {player1}!")
    elif total_score2 > total_score1:
        print(f" Kazanan: {player2}!")
    else:
        print(" Oyun Berabere!")

# Oyunu başlat
play_game()