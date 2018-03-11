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
    public String SAFETY = "SAFETY";
    public String AUX ="Annotation";
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
        this.DrawTOE(wside - bofst, slotVert);
        this.absMove(0,0); // Move back to start
        
        this.relMove(cofst,-bofst);
	Line(-l1-cofst*2, 0, CREASE); // Btm D base bend
	this.relMove(l1+cofst*2,0);
        
        this.relMove(0,-w2);
	Line(-l1-cofst*2,0, CREASE);
	this.relMove(l1+cofst*2,0);
        
        this.absMove(0,0); // Move back to start
        this.DrawBtmAndFront();

	this.absMove(wside - bofst, 0); //this.absMove(w2+cofst*2+bofst,0); // return to origin ???????????
	flap=(int) (l1/2); // base flap
        if ((flap > w1+bofst) && (flap < w1+bofst+cofst*2)) {
            flap=w1+bofst;
	}
        Line(0, -flap, CUT);
	Line(-(wside - (cofst + bofst)),0, CUT);

        this.absMove(-l1 - wside + bofst, 0);
        Line(0, -flap, CUT);
	Line(wside - (cofst + bofst),0, CUT);

        
	this.absMove(cofst, dmain-bofst+w1);
	ins1=dblbend+cofst;	
       
        if(style.equals("0470 P/S & T/S")) {
            psTopFlap_RC_Current(l1+cofst*2);
            this.absMove(cofst, this.dmain - bofst);
            Line(-(l1+cofst*2), 0, CREASE);
        } else {
            folderflap(l1+cofst*2 ,tuckflap,0,0,ins1,ins1,tuckrad,tuckrad);
            this.relMove(0,-w1);
            Line(-(l1+cofst*2), 0, CREASE);            
        }
        
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
        this.DrawTOE(wside - bofst, slotVert);
        this.absMove(-l1,0);
        this.Xaxis = -1;
        this.Yaxis = 1;        
        this.DrawBtmAndFront();
        
        this.Xaxis = 1;
        this.Yaxis = 1;   
        if(style.equals("0470 P/S & T/S")) {
            absMove(0, dmain);
            LidLockFlap();
        }
    
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
      Line(-ins1, 0, CUT); // Right side Btm
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

// Draw the Lugs section first
	if (dis<50) { // === 0 lugs ===
	  Line( dis-cofst, 0, this.CUT);
          
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
	Line(0,-w2, CUT); // Btm Base 
        
  	// SelectOn();
	Line(-bofst-cofst,-cofst*2, CUT); // inner flap - Side Goes inside TOE
	Line(wside, 0, CUT); //Line(w2-cofst,0, CUT);
	Line(0,-(dinr-(cofst+bofst)), CUT);
	Line(-wside, 0, CUT); //Line(-w2+cofst,0, CUT);
  	// SelectOff();
	
	Line(-l1+bofst*2,0, CUT);
	this.relMove(l1-bofst*2,0);
	  // SelectOn();
	Line(0,dinr-(cofst+bofst), CREASE);      
        
  } // SideSection
  
  
   protected void psTopFlap_RC_Current(double dist) {
  // Top Flap - Peel & Seal / Rippa Tape section    
    double tabBang = 7;
    double tabRip = 16.5;
    double tabInrCutIn = 7.5;
    double topCutIn = 17.5; //17.4235856;
    double tabVertGap = 9.5;
    double tabLen = 32;
    double tabPsVert = 26;
    double ps = 20;
    double strght = this.tuckflap - (tabPsVert + tabRip);
    double tabArcIn = 31.07454975, tabArcUp = 0.3511986, tabArcRad = 28.57521973; // Movements to center from x/ytmp
    double topArcin = 41.27815623, topArcUp = 18.43147838, topArcRad = 33.83333337;  // Movements to center from x/ytmp
    double xtmp = 0, ytmp = 0;
    
    // Right Side PS Tab Section
    Line(-dist, 0, CREASE);
    relMove(dist, 0);
    Line(0, strght, CUT);
//    this.relMove(lmain + (buffer * 2), 0);
//    Line(0, strght, "CUTCRE6");
//    this.relMove(-(lmain + (buffer * 2)), 0);
    xtmp = this.xabs; // Store
    ytmp = this.yabs;
    Line(-tabLen, tabBang, SAFETY);
    relMove(0, tabVertGap);
    Line(tabLen - tabInrCutIn, 0, SAFETY);
    // Tab
    this.arc2(xtmp - tabArcIn, ytmp + tabArcUp, tabArcRad, 0.39235112, 34.41153183, xtmp, ytmp, CUT);
    // Top Arc
    this.arc2(xtmp - topArcin, ytmp + topArcUp, topArcRad, 356.72731750, 45.34770455, xtmp, ytmp, CUT);
    
    this.absMove(xtmp - topCutIn, ytmp + this.tuckflap - strght);
  //  relMove(-topCutIn + tabInrCutIn, tabPsVert);
    
    Line(-dist + (topCutIn * 2), 0, CUT);
    
    // Left Side PS Tab Section
    this.absMove(xtmp - dist, ytmp);
    xtmp = this.xabs; // Store
    ytmp = this.yabs;
    
    Line(0, -strght, CUT);
    this.relMove(0, strght);
    Line(tabLen, tabBang, SAFETY);
    
    relMove(0, tabVertGap);
    Line(-tabLen + tabInrCutIn, 0, SAFETY);
    // Tab
    this.arc2(xtmp + tabArcIn, ytmp + tabArcUp, tabArcRad, 145.58846817, 179.60764888, xtmp, ytmp, CUT);
    // Top Arc
    this.arc2(xtmp + topArcin, ytmp + topArcUp, topArcRad, 134.65229545, 183.27268250, xtmp, ytmp, CUT);
    

   
  // **** Peel & Seal / Rippa Tape ****
  double psEdgeGap = 10;
  double psTopDown = 4;
  double psWidth = 20;
  double ripperWidth = 4;
  double psRipGap = 4;
  double psTopLine = dist - (psEdgeGap * 2);
  
  this.absMove(-dist + cofst + psEdgeGap, dmain - bofst + w1 + tuckflap - psTopDown);  
  
  Line(psTopLine, 0, AUX);  
  relMove(0, -psWidth);
  Line(-psTopLine, 0, AUX);  
  relMove(0, -psRipGap);
  Line(psTopLine, 0, AUX);
  relMove(0, -ripperWidth);
  Line(-psTopLine, 0, AUX);
  
  TextInsert((psTopLine / 2) - 15, 14, "Peel & Seal", AUX);
  TextInsert((psTopLine / 2) - 15, -1, "Rippa Tape", AUX);
  
  } // psTopFlap_RC_Current
  

private void LidLockFlap() {

    double lidTabAdd = 1.5; // Increase of Lid Tab over Slot (x2)
    double lidTab = (int)Math.floor(w1 * 0.4); // Width of flap
    double lidtabD = (int)Math.floor(dmain * 0.2); // Depth of Flap
    int lkflp = (int) Math.round((this.w1 / 3) * 1.33);
    double fg = (this.w1 - lkflp) / 2; // lock flap side gap 
     
    if (lidTab > 65) { // Floor & Ceiling
      if (lidTab > 65) {lidTab = 65;}
      if (lidTab < 40) {lidTab = 40;}
    }

  // Lid Main Body
    double flapBackCutAngle = 0;
    double hyp = (fg + lidTabAdd) + (lkflp - (lidTabAdd * 2));
    double flapFrontCutAngle = (int) ((fg + lkflp) - Math.sqrt(Math.pow(hyp, 2) - Math.pow(lidtabD, 2))) + 2;
    if (flapFrontCutAngle < 1) {  // stop problem with very long, short width flaps - Rad doesnt meet the edge
      flapFrontCutAngle = 0;
      JOptionPane.showMessageDialog(null, "flapFrontCutAngle = 0. Flap Angle cut not properly calculated.");
    }
    
    this.relMove(0, fg - bofst);
    
    Line(lidtabD, flapBackCutAngle, CUT);
    Line(0, lkflp - flapBackCutAngle - flapFrontCutAngle, CUT);
    Line(-lidtabD, flapFrontCutAngle, CUT);
    Line(0, -lkflp, CREASE);

    // Lock Slot
    absMove(0, dmain - (bofst * 2));
    this.relMove(fg + lidTabAdd, this.dblbend);
    Line(0, -dblbend, CUT);
    Line(lkflp - (lidTabAdd * 2), 0, CUT);
    Line(0, dblbend, CUT);
    
    this.relMove(0, this.dblbend); 
    Line(-lkflp + (lidTabAdd * 2), 0, CUT);
    
//    double slot = this.dblbend + 6;
//    Arc3ptRad oArc = new Arc3ptRad();
//    oArc.pt1X = this.xabs; // Absolute Values
//    oArc.pt1Y = this.yabs;
//    oArc.pt2X = this.xabs + ((lkflp - (lidTabAdd * 2)) / 2);
//    oArc.pt2Y = this.yabs - slot/ 2;
//    oArc.pt3X = this.xabs;
//    oArc.pt3Y = this.yabs - slot;
//    oArc.FindCtrRad3PtOnArc();
//    
//    double aDat[] = oArc.ArcCenter(xabs, this.yabs, xabs - (lkflp - (lidTabAdd * 2)), yabs, oArc.radius, 3, "");
//    this.arc2(oArc.ctrX, oArc.ctrY, oArc.radius, oArc.EndAngle, oArc.StartAngle, oArc.pt3X, oArc.pt3Y, CUT);

    this.absMove(-bofst, -(w2 + dinr + bofst));
    relMove(fg-cofst, 0);
    Line(0, lidtabD, CUT);
    Line(lkflp - (lidTabAdd * 2) + (cofst * 2), 0, CUT);
    Line(0, -lidtabD, CUT);
}  // LidLockFlap
 



  public void allowanceSetup() {
    
    switch (flute) {
      case "E":  // E flute 
        dblbend=4;
        bofst=1;
        cofst=1;
        lug=4;
        l1=l+10;
        dmain=d+3;
        dotr=dmain-bofst*2;
        dinr=dotr-1;
        if(style.equals("0470 P/S & T/S")) {
            w1=w+3;
            w2=w+2;
            wside = w2 - 1;
        } else {
            w1=w+2;
            w2=w+3;
            wside = w2 - 1;            
        }
      break;// ==
      
      case "B": // B flute                                                                      
        dblbend=6;
        bofst=2;
        cofst=2;
        lug=4;
        l1=l+14; 
        dmain=d+5;
        dotr=dmain-bofst*2;
        dinr=dotr-2;
        if(style.equals("0470 P/S & T/S")) {
            w1=w+5;
            w2=w+3;
            wside = w2 - 1;
        } else {
            w1=w+3;
            w2=w+5;
            wside = w2 - 1;           
        }        
      break;// ==
      
      case "C": // C flute                                                                        
      case "EB":    
        dblbend=9;
        bofst=3;
        cofst=2;
        lug=5;
        l1=l+20;
        dmain=d+8;
        dotr=dmain-bofst*2;
        dinr=dotr-2;
        if(style.equals("0470 P/S & T/S")) {
            w1=w+9;
            w2=w+5;
            wside = w2 - (bofst - cofst);
        } else {
            w1=w+5;
            w2=w+9;
            wside = w2 - (bofst - cofst);          
        }          
      break; // ==
      
      case "BC": //                                                                                   
        dblbend=14;
        bofst=4;
        cofst=4;
        lug=5;
        l1=l+30;
        dmain=d+12;
        dotr=dmain-bofst*2;
        dinr=dotr-3;
        if(style.equals("0470 P/S & T/S")) {
            w1=w+14;
            w2=w+7;
            wside = w2 - 4;
        } else {
            w1=w+7;
            w2=w+14;
            wside = w2 - 4;        
        }        
      break; // ==
    } 
    //wside = w2 - (bofst - cofst);
    
    this.blks1 = tuckflap + w1 + dmain + w2 + dinr - bofst;
    this.blkn2 = l1 + wside + wside;
    // Actually 1st way - but taken from the d0421+ prog
    double blks1_2 = lug + dinr + dblbend + dotr + dmain + w2 + dinr - bofst; // this.blkn2 * 2;
    if (blks1_2 > this.blks1) {
        blks1_2 = this.blks1;
    }
    //System.out.println("***draw0427cls.allowanceSetup BI=" + blks1IntLk); // + "**" + (lug + dinr + dblbend + dotr + l1 - ((l1 - l2) / 2)) );
    
    if (d > l) {
      JOptionPane.showMessageDialog(null, "MAKE-UP WARNING /n/r Depth greater than Length - Extra bend may be needed in the turned in depth.", "Warning", JOptionPane.ERROR_MESSAGE);   
    } // if
    
    if (this.tuckflap < 55 && style.equals("0470 P/S & T/S")) {
      JOptionPane.showMessageDialog(null, "MAKE-UP WARNING /n/r Peel & Seal Flap < 55mm likely to cause poor make-up & sealing.", "Warning", JOptionPane.ERROR_MESSAGE);   
    } // if
    
  }
    
}