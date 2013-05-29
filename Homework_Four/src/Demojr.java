/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Homework #4
 * File: Demojr.java
 * NOTE: Class that is used for testing jr.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Demojr<T> extends DummyClass implements ActionListener, 
Serializable, Comparable<T>
{
   //*****PUBLIC**************************
   public Integer integerCheckPub = 1;
   public Integer integerCheckPubNul;
   public int intCheckPub = 5;
   public int intCheckNul;
   
   public Double doubleClassCheckPub = 3.0;
   public Double doubleClassCheckPubNul;
   public double doubleCheckPub = 6.0;
   public double doubleCheckPubNul; 
   
   public Boolean booleanClassCheckPubF = true;
   public Boolean booleanClassCheckPubT = false;
   public Boolean booleanClassCheckNull;
   public boolean booleanCheckPubF = false;
   public boolean booleanCheckPubT = true;
   public boolean booleanCheckNul;
   
   public Short shortClassCheckPub = 2;
   public Short shortClassCheckNul;
   public short shortCheckPub = 1;
   public short shortCheckPubNul; 
   
   public Long longClassCheckPub = 4L;
   public Long longClassCheckNul;
   public long longCheckPub = 3L;
   public long longCheckPubNul;
   
   public Character charClassCheckPub = 'b';
   public Character charClassCheckNul;
   public char charCheckPub = 'a';
   public char charCheckPubNul;
   
   public String stringCheckPub = "check";
   public String stringCheckNul;
   
   public Byte byteClassCheckPub = 0;
   public Byte byteClassCheckNul;
   public byte byteCheckPub = 1;
   public byte byteCheckPubNul; 
   
   public Float floatCheckClassPub = 21.0f;
   public Float floatCheckClassnul;
   public float floatCheckPub = 20.0f;
   public float floatCheckPubNul;
   
   //**************PRIVATE**************
   private Integer integerCheckPrivate = 1;
   private Integer integerCheckPrivatebNul;
   private int intCheckPri = 5;
   private int intCheckPriNul;
   
   private Double doubleClassCheckPri = 3.0;
   private Double doubleClassCheckPriNul;
   private double doubleCheckPri = 6.0;
   private double doubleCheckPriNul; 
   
   private Boolean booleanClassCheckPriF = true;
   private Boolean booleanClassCheckPriT = false;
   private Boolean booleanClassCheckPriNull;
   private boolean booleanCheckPriF = false;
   private boolean booleanCheckPriT = true;
   private boolean booleanCheckPriNul;
   
   private Short shortClassCheckPri = 2;
   private Short shortClassCheckPriNul;
   private short shortCheckPri = 1;
   private short shortCheckPriNul; 
   
   private Long longClassCheckPri = 4L;
   private Long longClassCheckPriNul;
   private long longCheckPri = 3L;
   private long longCheckPriNul;
   
   private Character charClassCheckPri = 'b';
   private Character charClassCheckPriNul;
   private char charCheckPri = 'a';
   private char charCheckPriNul;
   
   private String stringCheckPri = "check";
   private String stringCheckPriNul;
   
   private Byte byteClassCheckPri = 0;
   private Byte byteClassCheckPriNul;
   private byte byteCheckPri = 1;
   private byte byteCheckPriNul; 
   
   private Float floatCheckClassPri = 21.0f;
   private Float floatCheckClassPriNul;
   private float floatCheckPri = 20.0f;
   private float floatCheckPriNul;
   
   //**************PROTECTED****************
   protected Integer integerCheckProtected = 1;
   protected Integer integerCheckProtecteNull;
   protected int intCheckPro = 5;
   protected int intCheckProNul;
   
   protected Double doubleClassCheckPro = 3.0;
   protected Double doubleClassCheckProNul;
   protected double doubleCheckPro = 6.0;
   protected double doubleCheckProNul; 
   
   protected Boolean booleanClassCheckProF = true;
   protected Boolean booleanClassCheckProT = false;
   protected Boolean booleanClassCheckProNull;
   protected boolean booleanCheckProF = false;
   protected boolean booleanCheckProT = true;
   protected boolean booleanCheckProNul;
   
   protected Short shortClassCheckPro = 2;
   protected Short shortClassCheckProNul;
   protected short shortCheckPro = 1;
   protected short shortCheckProNul; 
   
   protected Long longClassCheckPro = 4L;
   protected Long longClassCheckProNul;
   protected long longCheckPro = 3L;
   protected long longCheckProNul;
   
   protected Character charClassCheckPro = 'b';
   protected Character charClassCheckProNul;
   protected char charCheckPro = 'a';
   protected char charCheckProNul;
   
   protected String stringCheckPro = "check";
   protected String stringCheckProNul;
   
   protected Byte byteClassCheckPro = 0;
   protected Byte byteClassCheckProNul;
   protected byte byteCheckPro = 1;
   protected byte byteCheckProNul; 
   
   protected Float floatCheckClassPro = 21.0f;
   protected Float floatCheckClassProNul;
   protected float floatCheckPro = 20.0f;
   protected float floatCheckProNul;
   
   //OTHER DATA
   private ArrayList<String> arrayList = new ArrayList<String>();
   public HashMap<String, Integer> hm = new HashMap<String, Integer>();
   private HashMap<String, String> privateMap = new HashMap<String, String>();
   protected HashMap<String, String> protMap;
   
   protected String[] str;
   public int[] intgr = new int[10];   
   private boolean[] boo = new boolean[11];
   
   public static final int number = 1;
   private static final long serialVersionUID = 1L;
   protected static final double doubleNumber = 1.9;
 
   int noModifierInt;
   ArrayList<String> noModiferArrayList;
   int[] noModifierIntArray;
   public static ArrayList<String> arrayListPub;
   
   //Constructors - public
//********************************Demojr()********************************
   public Demojr()
   { }
   
//********************************Demojr()********************************
   public Demojr(int a)
   { }
   
//********************************Demojr()********************************
   public Demojr(int z, int zz)
   { }
   
//********************************Demojr()********************************
   public Demojr(ArrayList<String> aa)
   { }
   
//********************************Demojr()********************************
   public Demojr(ArrayList<String> list, HashMap<String, Integer> hm)
   { }
   
   //Constructors - private
//********************************Demojr()********************************
   private Demojr(Integer kj)
   { }
   
//********************************Demojr()********************************
   private Demojr(HashMap<String, String> hmP, ArrayList<String> newList)
   { }
   
//********************************Demojr()********************************
   private Demojr(long[] arrayLong, int[] arrayInt, int...a)
   {}
   
//********************************Demojr()********************************
   private Demojr(short b, String d, boolean a, byte k, char z)
   {}
   
   //Constructors - Protected
//********************************Demojr()********************************
   protected Demojr(HashMap<String, Integer> l)
   {  }
 
//********************************Demojr()********************************
   protected Demojr(Long kj)
   { }
   
//********************************Demojr()********************************
   protected Demojr(HashMap<String, String> hmP, ArrayList<String> newList, int[] d)
   { }
   
//********************************Demojr()********************************
   protected Demojr(long[] arrayLong, int[] arrayInt, byte k, int...a)
   {}
   
   protected Demojr(short b, String d, boolean a, 
                    byte k, char z, ArrayList<String> aa)
   {}
   
   //****METHODS PUBLIC
//*******************************intCheck()*******************************
   public void intCheck()
   { }
   
//********************************getInt()********************************
   public int getInt(int a)
   { return 1; }

//******************************getString()*******************************
   public String getString(String a)
   { return "string"; }
   
//******************************getHashMap()******************************
   public HashMap<String, Integer> getHashMap(String a, HashMap<String, Integer> hm)
   { return null; }
   
//*****************************getByteArray()*****************************
   public byte[] getByteArray(byte d, String f, int...a)
   { return null; }
   
//*****************************getArrayList()*****************************
   public ArrayList<String> getArrayList(int a, ArrayList<String> array)
   { return null; }
   
   //no modifier 
//********************************getInt()********************************
   int getInt(int a, int b)
   { return 2; }
   
   //Methods - private
//****************************checkingThings()****************************
   private void checkingThings()
   { }
   
//*****************************checkItAgain()*****************************
   private boolean checkItAgain()
   { return true; }
   
//*****************************getIntArray()******************************
   private int[] getIntArray(boolean b, int[] a, double...d)
   { return null; }
   
   private ArrayList<Integer> getList(ArrayList<String> as, 
                                      HashMap<String, Integer> hm, short s)
   { return null; }
   
   //Methods - protected
//***************************protectedMethod()****************************
   protected void protectedMethod()
   { }
   
//*******************************checkIt()********************************
   protected boolean checkIt()
   {  return false; }
   
//******************************getBoolean()******************************
   protected boolean getBoolean(boolean g)
   { return false; }
   
//*******************************getList()********************************
   protected List<String> getList(String[] array, char a, String regString)
   { return null; }


   @Override
//***************************actionPerformed()****************************
   public void actionPerformed(ActionEvent arg0)
   {  }

   @Override
//******************************compareTo()*******************************
   public int compareTo(T o)
   {   return 0;  }

  
}

