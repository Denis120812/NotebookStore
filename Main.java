
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            LaptopStore store = new LaptopStore();
            Map<String, Object> filters = new HashMap<>();

            System.out.println("Параметры ноутбуков:");
            System.out.println("1 - Производитель");
            System.out.println("2 - Операционная система");
            System.out.println("3 - ОЗУ");
            System.out.println("4 - Объем жесткого диска");
            System.out.println("5 - Цвет");
            System.out.println("Введите число для выбора параметра (или 0 для выхода): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 0) {
                System.out.println("Программа завершена.");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Недопустимое значение. Пожалуйста, введите число из меню.");
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Выберите производителя:");
                    for (String manufacturer : store.getAllManufacturers()) {
                        System.out.println(manufacturer);
                    }
                    System.out.println("Выберите производителя: ");

                    String selectedManufacturer = scanner.nextLine();
                    filters.put("Manufacturer", selectedManufacturer);
                    break;
                case 2:
                    System.out.println("Операционная система:");
                    for (String os : store.getAllOss()) {
                        System.out.println(os);
                    }
                    System.out.println("Выберите операционную систему: ");

                    String selectedOs = scanner.nextLine();
                    filters.put("Operating System", selectedOs);
                    break;
                case 3:
                    System.out.println("ОЗУ:");
                    for (Integer ram : store.getAllRams()) {
                        System.out.println(ram);
                    }
                    System.out.println("Выберите ОЗУ: ");

                    int selectedRams = scanner.nextInt();
                    scanner.nextLine();
                    filters.put("RAM", selectedRams); 
                    break;
                case 4:
                    System.out.println("Объем жесткого диска:");
                    for (Integer storage : store.getAllStorages()) {
                        System.out.println(storage);
                    }
                    System.out.println("Выберите объем диска: ");

                    int selectedStorages = scanner.nextInt();
                    scanner.nextLine();
                    filters.put("Storage", selectedStorages); 
                    break;
                case 5:
                    System.out.println("Цвет:");
                    for (String color : store.getAllColors()) {
                        System.out.println(color);
                    }
                    System.out.println("Выберите цвет: ");

                    String selectedColors = scanner.nextLine();
                    filters.put("Color", selectedColors); 
                    break;
            }

            Set<Laptop> filteredLaptops = store.filter(filters);
            System.out.println("Отфильтрованные ноутбуки:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop.getManufacturer() + " " + laptop.getOs() + " " + laptop.getRam() + "GB RAM " + laptop.getStorage() + "GB storage " + laptop.getColor());
            }
            // Остановка программы после вывода отфильтрованных ноутбуков
            break;
        }
    }
}