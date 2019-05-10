import java.util.ArrayList;

public class Hashtable<k,v> {
    public class HashNodes<k, v> {
        private k key;
        private v value;
        private HashNodes<k, v> next;

        public HashNodes(k key, v value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public void setNext(HashNodes<k, v> next) {
            this.next = next;
        }

        public HashNodes<k, v> getNext() {
            return next;
        }

        public void setKey(k key) {
            this.key = key;
        }

        public k getKey() {
            return key;
        }

        public void setValue(v value) {
            this.value = value;
        }

        public v getValue() {
            return value;
        }
    }

    private ArrayList<HashNodes> slots;
    private int items;
    private final float LAMBDA = (float) 0.75;

    private int getSlot(k key) {
        int slot = key.hashCode();
        slot = slot % slots.size();
        return slot;
    }

    public Hashtable() {
        slots = new ArrayList<HashNodes>();
        items = 0;
    }

    public void put(k key, v value) {
        HashNodes hNode = new HashNodes(key, value);
        slots.add(hNode);

    }

    public Object get(k key) {
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).getKey() == key) {
                return slots.get(i).getValue();
            }
        }
        return null;
    }

    public String remove(k key) {
        String tempVal = null;
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).getKey() == key) {
                tempVal = (String) slots.get(i).getValue();
                slots.remove(i);
                return tempVal;
            }
        }
        return null;
    }

    public boolean containsKey(k key) {
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i) == key)
                return true;
        }
        return false;
    }

    public void incSlots() {
        ArrayList<HashNodes> tempSlots = new ArrayList<HashNodes>();
    }
}