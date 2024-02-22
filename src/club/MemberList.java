package club;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MemberList {
    private Member[] members; //holds Basic, Family, or Premium objects
    private int size; //number of objects in the array
    private final int NOT_FOUND = -1;
    private final int INITIAL_CAPACITY = 4;
    private final int CAPACITY_INCREMENT = 4;

    private int find(Member member) {
        for(int i = 0; i < size; i ++){
            if(this.members[i].equals(member)) return i;
        }
        return NOT_FOUND;
    }

    private void grow() {
        Member[] longer = new Member[size + CAPACITY_INCREMENT];
        for(int i = 0; i < size; i++){
            longer[i] = this.members[i];
        }
        this.members = longer;
    }

    public boolean contains(Member member) {
        return this.find(member) != NOT_FOUND;
    }

    public boolean add(Member member) {
        if(this.contains(member)){
            if(this.size == this.members.length) this.grow();
            this.size++;
            return true;
        }
        return false;
    }

    public boolean remove(Member member) {
        if(!this.contains(member)){
            return false;
        }
        int indexToRemove = this.find(member);
        this.members[indexToRemove] = null;

        for (int i = indexToRemove; i < this.size - 1; i++) {
            this.members[i] = this.members[i + 1];
        }
        this.size--;
        return true;

    } //shift up to remove

    public void load(File file) throws IOException {


    }//from the text file

    public void printByCounty() {
    } //sort by county then zip code

    public void printByMember() {
    } //sort by member profile

    public void printFees() {
    } //print the array as is with the next due amounts
}
