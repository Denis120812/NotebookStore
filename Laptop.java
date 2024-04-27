
import java.util.*;

class Laptop { // структура для ноутбука с полями
    String manufacturer;
    String os;
    int ram;
    int storage;
    String color;

    public Laptop(String manufacturer, String os, int ram, int storage, String color) {
        this.manufacturer = manufacturer;
        this.os = os;
        this.ram = ram;
        this.storage = storage;
        this.color = color;
    }

    public String getManufacturer() { return manufacturer; }
    public String getOs() { return os; }
    public int getRam() { return ram; }
    public int getStorage() { return storage; }
    public String getColor() { return color; }
}

class LaptopStore { // множество ноутбуков с параметрами
    Set<Laptop> laptops;

    public LaptopStore() {
        laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", "Windows", 16, 512, "Black"));
        laptops.add(new Laptop("Lenovo", "Linux", 8, 256, "Silver"));
        laptops.add(new Laptop("Apple", "MacOS", 16, 1024, "Space Gray"));
        laptops.add(new Laptop("Acer", "Windows", 32, 1024, "Blue"));
        laptops.add(new Laptop("Dell", "Linux", 16, 512, "Black"));
        laptops.add(new Laptop("Apple", "MacOS", 16, 1024, "Silver"));
        laptops.add(new Laptop("Lenovo", "Linux", 32, 512, "Silver"));
        laptops.add(new Laptop("Lenovo", "Linux", 32, 256, "Space Gray"));
    }

    public Set<Laptop> filter(Map<String, Object> filters) {// карта фильтров с ключами
        Set<Laptop> result = new HashSet<>(laptops);
        for (Map.Entry<String, Object> filter : filters.entrySet()) {
            String key = filter.getKey();
            Object value = filter.getValue();
            if (key.equals("Manufacturer")) {
                result.retainAll(laptopsWithManufacturer((String) value));
            } else if (key.equals("Operating System")) {
                result.retainAll(laptopsWithOperatingSystem((String) value));
            } else if (key.equals("RAM")) {
                result.retainAll(laptopsWithRAM((Integer) value));
            } else if (key.equals("Storage")) {
                result.retainAll(laptopsWithStorage((Integer) value));
            } else if (key.equals("Color")) {
                result.retainAll(laptopsWithColor((String) value));

            }
        }
        return result;
    }

    private Set<Laptop> laptopsWithManufacturer(String manufacturer) {
        Set<Laptop> result = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.getManufacturer().equals(manufacturer)) {
                result.add(laptop);
            }
        }

        return result;
    }

    private Set<Laptop> laptopsWithOperatingSystem(String os) {
        Set<Laptop> result = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.getOs().equals(os)) {
                result.add(laptop);
            }
        }
        return result;
    }

    private Set<Laptop> laptopsWithRAM(Integer ram) {
        Set<Laptop> result = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.getRam() == ram) {
                result.add(laptop);
            }
        }
        return result;
    }

    private Set<Laptop> laptopsWithStorage(Integer storage) {
        Set<Laptop> result = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.getStorage() == storage) {
                result.add(laptop);
            }
        }
        return result;
    }

    private Set<Laptop> laptopsWithColor(String color) {
        Set<Laptop> result = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.getColor().equals(color)) {
                result.add(laptop);
            }
        }

        return result;
    }

    
    public Set<String> getAllManufacturers() {
        Set<String> manufacturers = new HashSet<>();
        for (Laptop laptop : laptops) {
            manufacturers.add(laptop.getManufacturer());
        }
        return manufacturers;
    }

    public Set<String> getAllOss() {
        Set<String> oss = new HashSet<>();
        for (Laptop laptop : laptops) {
            oss.add(laptop.getOs());
        }
        return oss;
    }

    public Set<Integer> getAllRams() {
        Set<Integer> rams = new HashSet<>();
        for (Laptop laptop : laptops) {
            rams.add(laptop.getRam());
        }
        return rams;
    }

    public Set<Integer> getAllStorages() {
        Set<Integer> storages = new HashSet<>();
        for (Laptop laptop : laptops) {
            storages.add(laptop.getStorage());
        }
        return storages;
    }

    public Set<String> getAllColors() {
        Set<String> colors = new HashSet<>();
        for (Laptop laptop : laptops) {
            colors.add(laptop.getColor());
        }
        return colors;
    }
}

