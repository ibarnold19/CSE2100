package tree234;

//tree234.java
//demonstrates 234 tree
//to run this program: C>java Tree234App
import java.io.*;                 // for I/O
import java.lang.Integer;         // for parseInt()
////////////////////////////////////////////////////////////////
class DataItem
{
public double dData;        // one data item
//--------------------------------------------------------------
public DataItem(double dd)  // constructor
   { dData = dd; }
//--------------------------------------------------------------
public void displayItem()   // display item, format "/27"
   { System.out.print("/"+dData); }
//--------------------------------------------------------------
}  // end class DataItem
