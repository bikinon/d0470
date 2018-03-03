/*
 * 2/3/2018 TG
 */
package d0470;

import javax.swing.JOptionPane;

/**
 *
 * @author master
 */
public class draw0470 extends dxf12objects {

//MACRO lp044301  FEFCO 0470

    public double l = 0;
    public double w = 0;
    public double d = 0;
    public String style = "0470";
    public String unit = "m";
    public String flute = "E";

    public double dotr = 0;
    public double dinr = 0;
    public double dblbend = 0;
    public double bofst=0;
    public double bofstL = 0;
    public double bofstR = 0;
    public double bofst2 = 0;
    public double cofst = 0;
    public double cofst2 = 0;
    public double lug = 0;

 // VAR LENGTH dotr,dinr,dblbend,bofst,cofst,lug,
    public double l1 = 0;
    public double w1 = 0;
    public double d1 = 0;
    public double dmain = 0;
    public double tuckflap=30;
    public double tuckrad=15;
    public double w2 = 0;
    public double wside = 0; // added to make the side TOE inside flap work better
    public double flap = 0;
    public double ins1 = 0;
    public double temp = 0;

    public double ba=0;
    public double fa=0; 
    public int slotType = 0; // 1=  , 2=  
    public int slotVert = 1;
//     public int slotHorz = 1;
     
    public double blks1 = 0;
    public double blkn2 = 0;

    public double eliteFlexoS1 = 1165;
    public double eliteFlexoN2 = 1590;
    public int noUpS1 = 0;
    public int noUpN2 = 0;
    
    public String CUT = "CUT";
    public String CREASE = "CREASE";
    public int col = 1; // Line Colour
    public String ltype = "CONTINUOUS"; // Line Type
// end attributes
  
  // start methods
  // ****************************    
  public String Draw0470() {    

      this.dxf += this.dxf_header12();
      this.absMove(0,0);        
        // start in main depth panel - Bottom Right Side

	  // SelectOn();
        this.DrawTOE(wside - cofst, slotVert);
        this.absMove(0,0); // Move back to start
        
        this.relMove(cofst,-bofst);
	Line(-l1-cofst*2, 0, CREASE); // Btm D base bend
	this.relMove(l1+cofst*2,0);
        
        this.relMove(0,-w2);
	Line(-l1-cofst*2,0, CREASE);
	this.relMove(l1+cofst*2,0);
        
        this.absMove(0,0); // Move back to start
        this.DrawBtmAndFront();

	this.absMove(wside - cofst, 0); //this.absMove(w2+cofst*2+bofst,0); // return to origin ???????????
	flap=(int) (l1/2); // base flap
        if ((flap > w1+bofst) && (flap < w1+bofst+cofst*2)) {
            flap=w1+bofst;
	}
        Line(0, -flap, CUT);
	Line(-(wside - (cofst * 2)),0, CUT);

        this.absMove(-l1 - wside + cofst, 0);
        Line(0, -flap, CUT);
	Line(wside - (cofst * 2),0, CUT);

        
	this.absMove(cofst, dmain-bofst+w1);
	ins1=dblbend+cofst;	
	folderflap(l1+cofst*2 ,tuckflap,0,0,ins1,ins1,tuckrad,tuckrad);
	
	this.relMove(0,-w1);
	Line(-(l1+cofst*2), 0, CREASE);

	if (dinr+dblbend-bofst<w1) { // extra to tuck flap
            this.absMove(cofst, dmain-bofst+w1);
            Line(0, -w1+dinr+dblbend-bofst, CUT);
                
            this.absMove(-l1-cofst, dmain-bofst+w1);
            Line(0, -w1+dinr+dblbend-bofst, CUT);               
	}
        
        this.absMove(-l1,0); // Move opposite side
        slotHorz = -1;
        this.Xaxis = -1;
        this.Yaxis = 1;
        this.DrawTOE(wside - cofst, slotVert);
        this.absMove(-l1,0);
        this.Xaxis = -1;
        this.Yaxis = 1;        
        this.DrawBtmAndFront();
    
    dxf +="  0\r\n";
    dxf +="ENDSEC\r\n";
    dxf +="  0\r\n";
    dxf +="EOF\r\n";
    
    return dxf;
  }
  // ************************************    

  
  /**
  * @param dis - Horz Distance
  * @param flap  - length of flap Vert
  * @param a1  - angle cut side 1 (additional to ins1 value)
  * @param a2  - angle cut side 2
  * @param ins1  - inset step before starting to draw flap
  * @param ins2  - inset step at end of flap
  * @param r1  - radius on side 1
  * @param r2  - radius on side 2
  */
  private void folderflap(double dis, double flap, double a1, double a2, double ins1, double ins2, double r1, double r2) {// CONST vector start, endpnt_Xaxis, CONST Boolean YAxisUpwards,CONST Length flap,a1,a2,ins1,ins2,r1,r2)
    // folder type flap 14/12/1997 Tim Gathercole - Java version 24/12/2016
    double e1 =0 , e2 = 0, e3 = 0;
    // Starts @ Btm of Flap on Right CUT...
    
    if (ins1 > 0) {
      Line(-ins1, 0, "CUTCRE_6X6");
    }
    Line(-(dis-ins1-ins2), 0, CREASE);
    
    if (ins2 > 0) {
      Line(-ins2, 0, CUT);
    }
    relMove(ins2, 0);  
    Line(a1, flap, CUT); // e1=
    Line(dis-ins2-ins1-a1-a2, 0, CUT); // e2
    Line(a2, -flap, CUT); // e3
    
    //        IF r1>0 THEN // radius required?
    //          FILLET(e1,e2,Getmid(e1),Getmid(e2),r1);
    //        END;
    //        IF r2>0 THEN
    //          FILLET(e2,e3,Getmid(e2),Getmid(e3),r2);
    //        END;
    relMove(ins1, 0);
  } // folderflap
  

  
 /**
  * Create Full TOE drawing - main DXF returned ** From PHP **
  * @return string
  */
  public String DrawTOE(double dis, int slotVert)  {
    double x=0, y=0;
    double slotw = dblbend + 1; // width of lock slot
    
    double lugAng = 2;
    double minLug = 25;
    double min3Lugs = 900;
    double min1Lug = 101;
    double min0Lug = 50;  
    
    if (slotVert == 0) {
      slotVert = 1;
    }
      
    Line(0,dotr, CREASE); // main outline of side (RIGHT)
    Line(cofst, bofst, this.CUT);
    Line(0, dblbend-bofst, this.CUT);
    Line(0,dinr, this.CUT);

// Draw the lugs section
	if (dis<50) { // === 0 lugs ===
	  Line( dis-cofst*2, 0, this.CUT);
        } else if (dis<121) { // === 1 lug ===
		y=(int) (dis/3);
		x=dis-y*2; // div by 3rds
		Line( y-cofst, 0, this.CUT); // cut then lug
		Line(lugAng, lug, this.CUT);
		Line( x-(lugAng*2), 0, this.CUT);
		Line(lugAng, -lug, this.CUT);
		Line( y, 0, this.CUT);
        } else if (dis>900) { // === 3 lugs ===
		
            y=(int) (dis/8);
		x=y;
		Line( y-cofst, 0, this.CUT); // cut then lug
		Line(lugAng, lug, this.CUT);
		Line( x-(lugAng*2), 0, this.CUT);
		Line(lugAng, -lug, this.CUT);
		Line( (dis-x*3-y*2)/2, 0, this.CUT);
		Line(lugAng, lug, this.CUT); // middle lug
		Line( x-(lugAng*2), 0, this.CUT);
		Line(lugAng, -lug, this.CUT);
		Line( (dis-x*3-y*2)/2, 0, this.CUT);
		Line(lugAng, lug, this.CUT); // other lug
		Line( x-(lugAng*2), 0, this.CUT);
		Line(lugAng, -lug, this.CUT);
		Line( y, 0, this.CUT);
        } else { // === 2 lugs ==============
		y=(int) (dis/6)/1;
		x=y; // lug size is width bend div by 6 to std with louth
//		y=y-cofst; // offset reduction
  	if (x < minLug) {
	  x = minLug;
        }
		Line( y-cofst, 0, this.CUT); // cut then lug
		Line(lugAng, lug, this.CUT);
		Line( x-(lugAng*2), 0, this.CUT);
		Line(lugAng, -lug, this.CUT);
		Line( dis-x*2-y*2, 0, this.CUT);
		Line(lugAng, lug, this.CUT); // other lug
		Line( x-(lugAng*2), 0, this.CUT);
		Line(lugAng, -lug, this.CUT);
		Line( y, 0, this.CUT);
         }

 	Line(0,-dinr, this.CUT); // other outline of side
	Line(0,-dblbend, this.CUT);
	Line(0,-dotr, this.CUT);  

	this.relMove(0, dotr);
  Line( -dis, 0, CREASE);
	this.relMove(cofst, dblbend);
  Line( dis-cofst, 0, CREASE);
	this.relMove(0,-dotr-dblbend);
        
        
   // Lock holes
    if (dis < min0Lug) { // === 0 lugs ===
      Line( -dis, 0, CREASE);
    } else if (dis < min1Lug) { // === 1 lug ===
      Line( -y, 0, CREASE);
      this.Xaxis = -1 * slotHorz;
      this.Yaxis = slotVert;   
      this.TheSlot(-x, slotw);
      this.Xaxis = 1 * slotHorz;
      this.Yaxis = 1;   
      //    SetCurrent( Find( "Crease" ) );
      Line( -y, 0, CREASE);
    } else if (dis>min3Lugs) { // === 3 lugs ===
      Line( -y, 0, CREASE);
      this.Xaxis = -1 * slotHorz;
      this.Yaxis = slotVert;   
      this.TheSlot(-x, slotw);
      this.Xaxis = 1 * slotHorz;
      this.Yaxis = 1;   

      Line( (-dis+x*3+y*2)/2, 0, CREASE); // mid bend
      this.Xaxis = -1 * slotHorz;
      this.Yaxis = slotVert;   
      this.TheSlot(-x, slotw);
      this.Xaxis = 1 * slotHorz;
      this.Yaxis = 1;   
      
      Line( (-dis+x*3+y*2)/2, 0, CREASE);
      this.Xaxis = -1 * slotHorz;
      this.Yaxis = slotVert;   
      this.TheSlot(-x, slotw);
      this.Xaxis = 1 * slotHorz;
      this.Yaxis = 1;   
      //    SetCurrent( Find( "Crease" ) );
      Line( -y, 0, CREASE);
    } else { // === 2 lugs ==============
      Line( -y, 0, CREASE);
      this.Xaxis = -1 * slotHorz; // Quick fix - using slotHorz the whole thing needs re-writing
      this.Yaxis = slotVert;
      this.TheSlot(-x, slotw);

      this.Xaxis = 1 * slotHorz;
      this.Yaxis = 1;
      Line( -dis+x*2+y*2, 0, CREASE);
      this.Xaxis = -1 * slotHorz;
      this.Yaxis = slotVert;
      this.TheSlot(-x, slotw);
      this.Xaxis = 1 * slotHorz;
      this.Yaxis = 1;   
      Line( -y, 0, CREASE);
    }
    
    relMove(cofst, -bofstL); // move back to starting position
        
    
    return this.dxf; // this.dxf;
  } // DrawTOE
  

/**
  * 
  * @param float dis
  * @param float slotw
  */
  protected void TheSlot(double dis, double slotw) {
    // *** Lock Slots on TOE ***
    switch (slotType) {
      
      case 1: // square ends
      Line(-dis, 0, CUT);
      Line(0, -slotw, CUT); 
      Line(dis, 0, CUT); 
      Line(0, slotw, CUT);
      break;
      
      case 2: // U cut
      relMove(-dis, 0);
      Line(0, -slotw, CUT); 
      Line(dis, 0, CUT); 
      Line(0, slotw, CUT);
      break;
      
      default: // rounded ends
      Line(-dis, 0, CUT);
      if (slotHorz == 1) {  // Quick fix - the whole thing needs re-writing
        arc(0, -slotw, slotw/2, CUT, 1, CCW);  
      } else {
        arc(0, -slotw, slotw/2, CUT, 1, CW);
      }
      Line(dis, 0, CUT);  
      if (slotHorz == 1) {
        arc(0, slotw, slotw/2, CUT, 1, CW);
      } else {
        arc(0, slotw, slotw/2, CUT, 1, CCW);
      }        
    }
    
    relMove(-dis, 0); // saves multiple moves in main 
    
  } // TheSlot


  private void DrawBtmAndFront() {
	Line(cofst,-bofst, CUT);
	Line(0,-w2, CUT);
        
  	// SelectOn();
	Line(-bofst-cofst,-cofst*2, CUT); // inner flap - Side Goes inside TOE
	Line(wside, 0, CUT); //Line(w2-cofst,0, CUT);
	Line(0,-dinr+cofst, CUT);
	Line(-wside, 0, CUT); //Line(-w2+cofst,0, CUT);
  	// SelectOff();
	
	Line(-l1+bofst*2,0, CUT);
	this.relMove(l1-bofst*2,0);
	  // SelectOn();
	Line(0,dinr-cofst, CREASE);      
        
  } // SideSection
  
  
  

  public void allowanceSetup() {
    
    switch (flute) {
      case "E":  // E flute 
		dblbend=4;
		bofst=1;
		cofst=1;
		lug=4;
		l1=l+10;
		w1=w+2;
		w2=w+3;
                wside = w2 - 1;
		dmain=d+3;
		dotr=dmain-bofst*2;
		dinr=dotr-1;
      break;// ==
      
      case "B": // B flute                                                                      
		dblbend=6;
		bofst=2;
		cofst=2;
		lug=4;
		l1=l+14;
		w1=w+3;
		w2=w+6;
                wside = w2 - 1; 
		dmain=d+5;
		dotr=dmain-bofst*2;
		dinr=dotr-2;
      break;// ==
      
      case "C": // C flute                                                                        
      case "EB":    
		dblbend=9;
		bofst=3;
		cofst=2;
		lug=5;
		l1=l+20;
		w1=w+8;
		w2=w+18;
		wside = w2 - 2;
                dmain=d+8;
		dotr=dmain-bofst*2;
		dinr=dotr-2;
      break; // ==
      
      case "BC": //                                                                                   
		dblbend=14;
		bofst=5;
		cofst=4;
		lug=5;
		l1=l+30;
		w1=w+7;
		w2=w+14;
                wside = w2 - 4;
		dmain=d+12;
		dotr=dmain-bofst*2;
		dinr=dotr-3;
      break; // ==
    } 
    
    this.blks1 = tuckflap + w1 + dmain + w2 + dinr;
    this.blkn2 = l1 + w1 + w1;
    // Actually 1st way - but taken from the d0421+ prog
    double blks1_2 = lug + dinr + dblbend + dotr + dmain + w2 + dinr; // this.blkn2 * 2;
    if (blks1_2 > this.blks1) {
        blks1_2 = this.blks1;
    }
    //System.out.println("***draw0427cls.allowanceSetup BI=" + blks1IntLk); // + "**" + (lug + dinr + dblbend + dotr + l1 - ((l1 - l2) / 2)) );
    
    if (d > l) {
      JOptionPane.showMessageDialog(null, "MAKE-UP WARNING /n/r Depth greater than Length - Extra bend may be needed in the turned in depth.", "Warning", JOptionPane.ERROR_MESSAGE);   
    } // if
    
  }
    
}
