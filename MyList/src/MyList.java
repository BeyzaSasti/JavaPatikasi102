import static java.util.Collections.list;

public class MyList < B > {
    int capacity;
    B [] list;
    B [] listTemp;
    int listSize;

    public MyList () {
        this.capacity = 10;
        this.setList();
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.setList();
    }

    public int size() {
        return this.listSize;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(B data){
        if(this.size() < this.capacity) {
            list[this.listSize] = data;
            this.sizeCalculate();
        } else {
            this.capacity *= 2;
            this.updateCapacity();
            this.add(data);
        }
    }

    public B get(int index) {
        B i = this.list[index];
        return i;
    }

    public void remove(int index) {
        replaceToRemove(index);
        this.listSize--;
    }

    public void set(int index, B data) {
        this.list[index] = data;
    }

    @Override
    public String toString() {
        System.out.print("[");
        for(B i : list) {
            if (i != null) {
                System.out.print(i + ",");
            }
        }
        System.out.print("]");
        return " ";
    }

    public int indexOf(B data) {
        for(int i = 0; i < this.list.length; i++) {
            if(data == this.list[i]) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(B data){
        int lastIndex = -1;
        for(int i = 0; i < this.list.length; i++) {
            if (data == this.list[i]) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public boolean isEmpty() {
        if(this.size() == 0) {
            return true;
        }else {
            return false;
        }
    }

    public Object[] toArray() {
        Object [] tempObject = new Object[this.list.length];
        for(int i = 0; i < this.list.length; i++) {
            tempObject[i] = this.list[i];
        }
        return tempObject;
    }

    public void clear() {
        for (int i = 0; i < this.list.length; i++) {
            this.list[i] = null;
        }
    }

    public MyList<B> subList(int start, int finish) {
        MyList<B> array = new MyList<>(finish-start + 1);
        for(int i = start; i <= finish; i++){
            array.add((B) this.list[i]);
        }
        return array;
    }

    public boolean contains(B data) {
        for(int i = 0; i < this.list.length; i++) {
            if(data == this.list[i]) {
                return true;
            }
        }
        return false;
    }
    

    public void replaceToRemove(int index) {
        B[] listTemp2 = this.list;
        this.list[index] = null;
        for(int i = 0; i < listTemp2.length - 1; i++) {
            if(index == 0) {
                this.list[i] = listTemp2[i + 1];
            } else if(index != 0 && i < index) {
                this.list[i] = listTemp2[i];
            } else if(index != 0 && i > index) {
                this.list[i] = listTemp2[i + 1];
            }
        }
    }

    public void updateCapacity() {
        this.listTemp = (B[]) new Object[this.capacity];
        for(int i = 0; i < this.list.length; i++) {
            this.listTemp[i] = this.list[i];
        }
        this.list = this.listTemp;
    }
    public void sizeCalculate() {
        int x = 0;
        for(int i = 0; i < this.list.length; i++){
            if(this.list[i] != null) {
                x++;
            }
        }
        this.listSize = x;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public B[] getList() {
        return list;
    }

    public void setList() {
        this.list = (B[]) new Object[this.capacity];
    }

    public B[] getListTemp() {
        return listTemp;
    }

    public void setListTemp(B[] listTemp) {
        this.listTemp = listTemp;
    }

    public int getLintSize() {
        return listSize;
    }

    public void setLintSize(int lintSize) {
        this.listSize = lintSize;
    }
}
