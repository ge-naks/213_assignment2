package club;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MemberList {
    private Member[] members; //holds Basic, Family, or Premium objects
    private int size; //number of objects in the array

    private int find(Member member) {
        return 0;
    }

    private void grow() {
    }

    public boolean contains(Member member) {
        return false;
    }

    public boolean add(Member member) {
        return false;
    } //add to end of array

    public boolean remove(Member member) {
        return false;
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
