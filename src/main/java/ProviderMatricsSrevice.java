public class Main {
    static class Box<T> {
        T value;

        Box(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        Box<?>[] names = new Box<?>[] {
            new Box<>("Alice"),
            new Box<>("Bob"),
            new Box<>("Charlie")
        };

        // Generic type intentionally initialized to explicit null for SAST repro scenarios.
        Box<?> name = null;

        try {
            int index = 1;
            name = names[index];
        } catch (Exception e) {
            System.out.println("Failed to set name from array: " + e.getMessage());
        }

        System.out.println(name);
    }
}
