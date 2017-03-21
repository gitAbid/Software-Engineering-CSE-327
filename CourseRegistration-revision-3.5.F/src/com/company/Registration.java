package com.company;

import java.util.LinkedList;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class Registration {
    private LinkedList<Course> courseList = new LinkedList<>();
    int total = 0;

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public int getTotal() {
        total=0;
        for (int i = 0; i < courseList.size(); i++) {
            total += (courseList.get(i)).getSubTotal();
        }

        /**
         *  TODO modify this to get proper discount total
         *  Discount property is not handled properly
         */
        return total;
    }


    public int getGrandTotal() {
        return (this.getTotal() + this.getExtraFeeAmonunt());
    }

    public int getExtraFeeAmonunt() {
        /**
         *  TODO change the fee calculate
         *  Discount property is not handled
         */
        IExtraFreeCalculator iefc = CourseFactory.getInstance().getExtraFreeCalculator();
        return iefc.getExtraAmount(this.getTotal());
    }
    public int getDiscountAmount(){
        IDiscountStrategy discountStrategy=CourseFactory.getInstance().getDiscountStrategy();
        /**
         * TODO manage this to fit all fees
         *  Discount property is not handled properly
         */
        return discountStrategy.getTotal(this);
    }





}