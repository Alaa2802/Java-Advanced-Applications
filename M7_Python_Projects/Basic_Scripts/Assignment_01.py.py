import os

folder_path =os.getcwd()

with open("error_logs.txt", "w") as file1:
    file1.write("ERROR: Database connection failed.\n")
    file1.write("ERROR: Failed to load configuration file.\n")
    file1.write("ERROR: Network timeout occurred.\n")

with open("INFO_logs.txt", "w") as file2:
    file2.write("INFO: Server started successfully.\n")
    file2.write("INFO: User admin logged in.\n")
    file2.write("INFO: Backup process completed.\n")
    file2.write("INFO: Scheduled maintenance started.\n")

with open("WARNING_logs.txt", "w") as file3:
    file3.write("WARNING: High memory usage detected.\n")
    file3.write("WARNING: CPU temperature high.\n")

error_logs = 0

for filename in os.listdir(folder_path):
    if filename.endswith(".txt"):
        file_path = os.path.join(folder_path, filename)
        with open(file_path, "r") as file:
            for line in file:
                if "ERROR" in line:
                    error_logs += 1
                    print(f"{filename} dosyasında 'ERROR' bulundu.")

print(f"Dosyalarda toplam hata sayısı: {error_logs}")

