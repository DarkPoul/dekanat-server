package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;

@Entity
@Table(name = "grade_block")
public class GradeBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;

    @Column(name = "block_one")
    private String block_one;
    @Column(name = "block_two")
    private String block_two;
    @Column(name = "block_three")
    private String block_three;
    @Column(name = "block_four")
    private String block_four;
    @Column(name = "block_five")
    private String block_five;
    @Column(name = "block_six")
    private String block_six;
    @Column(name = "block_seven")
    private String block_seven;
    @Column(name = "block_eight")
    private String block_eight;

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlock_one() {
        return block_one;
    }

    public void setBlock_one(String block_one) {
        this.block_one = block_one;
    }

    public String getBlock_two() {
        return block_two;
    }

    public void setBlock_two(String block_two) {
        this.block_two = block_two;
    }

    public String getBlock_three() {
        return block_three;
    }

    public void setBlock_three(String block_three) {
        this.block_three = block_three;
    }

    public String getBlock_four() {
        return block_four;
    }

    public void setBlock_four(String block_four) {
        this.block_four = block_four;
    }

    public String getBlock_five() {
        return block_five;
    }

    public void setBlock_five(String block_five) {
        this.block_five = block_five;
    }

    public String getBlock_six() {
        return block_six;
    }

    public void setBlock_six(String block_six) {
        this.block_six = block_six;
    }

    public String getBlock_seven() {
        return block_seven;
    }

    public void setBlock_seven(String block_seven) {
        this.block_seven = block_seven;
    }

    public String getBlock_eight() {
        return block_eight;
    }

    public void setBlock_eight(String block_eight) {
        this.block_eight = block_eight;
    }
}
