package com.roslin.mwicks.spring.narf.enums;


public enum EnumMhc {
    
	BLANK(""),
	B2("B<sup>2</sup>"),
	B4("B<sup>4</sup>/B<sup>4</sup>, B<sup>12</sup>/B<sup>12</sup>, B<sup>4</sup>/B<sup>12</sup>"),
	B14("B<sup>14</sup>"),
	B15("B<sup>15</sup>"),
	B19("B<sup>19</sup>"),
	B21("B<sup>21</sup>"),
	B132("B<sup>132, 133, 134, 135</sup>"),
	B142("B<sup>142, 143, 144</sup>");

    String enumMhc;
     
    
    private EnumMhc(String enumMhc){
    	
        this.enumMhc = enumMhc;
    }
     
    
    public String getEnumMhc(){
    	
        return enumMhc;
    }	
    
}
