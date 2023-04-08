package deans.cameron.ticks_n_tokens_reviews;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class AddDetailsData {
    @PrimaryKey(autoGenerate = true)
    int addDetailsId;
    @ColumnInfo(name="childName")
    String childName;
    @ColumnInfo(name="childAge")
    int childAge ;
    @ColumnInfo(name="chore1")
    String chore1;
    @ColumnInfo(name="chore2")
    String chore2;
    @ColumnInfo(name="chore3")
    String chore3;
    @ColumnInfo(name="tntNumberSelection")
    int tntNumberSelection;
    @ColumnInfo(name="award")
    String award;
    @ColumnInfo(name="punishment")
    String punishment;

    public AddDetailsData(String childName, int childAge, String chore1, String chore2, String chore3, int tntNumberSelection, String award, String punishment) {
        this.childName = childName;
        this.childAge = childAge;
        this.chore1 = chore1;
        this.chore2 = chore2;
        this.chore3 = chore3;
        this.tntNumberSelection = tntNumberSelection;
        this.award = award;
        this.punishment = punishment;
    }

    @Ignore
    public AddDetailsData(int addDetailsId){this.addDetailsId = addDetailsId; }

    public int getAddDetailsId() {
        return addDetailsId;
    }

    public void setAddDetailsId(int addDetailsId) {
        this.addDetailsId = addDetailsId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public int getChildAge() {
        return childAge;
    }

    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }

    public String getChore1() {
        return chore1;
    }

    public void setChore1(String chore1) {
        this.chore1 = chore1;
    }

    public String getChore2() {
        return chore2;
    }

    public void setChore2(String chore2) {
        this.chore2 = chore2;
    }

    public String getChore3() {
        return chore3;
    }

    public void setChore3(String chore3) {
        this.chore3 = chore3;
    }

    public int getTntNumberSelection() {
        return tntNumberSelection;
    }

    public void setTntNumberSelection(int tntNumberSelection) {
        this.tntNumberSelection = tntNumberSelection;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }
}
