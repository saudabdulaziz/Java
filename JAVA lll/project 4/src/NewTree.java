
// Program to create a recursive tree.
/*
 * @author Saud Aljandal
 * lab4
 */
import java.applet.Applet;
import java.awt.*;
 
public class NewTree extends Applet {
    private final int APPLET_WIDTH= 320;
    private final int APPLET_HEIGHT = 320;
    private final double START_SIZE = 110.0;
    private final double START_ANGLE= 180.0;
    private final double CHANGE_ANGLE=30.0;
    private final double FACTOR=2.0;
    private final double MIN_SIZE=10.0;
    //=======
    	Color SKY = new Color(79, 146, 255); // Color object for the sky section
    	Color GRASS = new Color(27, 86, 19); // Color object for the grass section.
    	Color TREE_COLOR = new Color(130, 74, 23);
    	Color[] LEAVES_COLORS =
    	{new Color(234, 224, 110), new Color(92, 135, 86), new Color(56, 89, 52), new Color(27, 66, 21)};
    	Color[] CLOUD_COLORS = { new Color(192, 196, 192), new Color(232, 232, 232), new Color(255, 255, 255)};
    	private final double GRASS_SECTION = 60.0; // 320/4 = 60
    	
 
    // Initialize the applet.
    public void init(){
        setSize(APPLET_WIDTH, APPLET_HEIGHT);
        setBackground(SKY);
    }
   
    // Create the drawing that displays on the applet.              
    public void paint(Graphics page) {
    		page.setColor(GRASS);
    		page.fillRect(0, 260, APPLET_WIDTH, (int)GRASS_SECTION);
    	//clouds before trees	
    		drawCloud(page,pickRandom(0,APPLET_WIDTH),pickRandom(0,80),pickRandom(39,40),pickRandom(49,50),0);
    	//Randomly choose # of trees:
    		for(int i=0; i < pickRandom(5,8); i++){
        drawTree(page, pickRandom(50,APPLET_WIDTH), pickRandom(260,APPLET_HEIGHT), pickRandom(50,(int)START_SIZE), START_ANGLE);
    		}
    }
    public void drawTree( Graphics page, int x, int y, double size, double angle ) {
    		page.setColor(TREE_COLOR);//Tree color
        Point endPoint = calculatePoint(x, y, size+3, angle );
        //widen the branches so they are not stick figures.
    		int[] xpoints = {x, x+2, endPoint.x+2,endPoint.x};
    		int[] ypoints = {y, y, endPoint.y, endPoint.y};
    		int npoints = 4;
    		Polygon tree = new Polygon(xpoints,ypoints,npoints);
    		page.setColor(TREE_COLOR);
    		page.fillPolygon(tree);
    	
    	//DRAWLEAFS  called HERE:
    	drawLeaf(page, endPoint.x    ,endPoint.y     , 6  ,7 ,angle/8 , pickRandom(0,3));
        if (size > MIN_SIZE) {
        	for(int i=0; i<pickRandom(5,8); i++){
            drawTree(page, endPoint.x, endPoint.y,
                size/FACTOR, pickRandom((int)angle+(int)CHANGE_ANGLE,140));
            drawTree(page, endPoint.x, endPoint.y,
                size/FACTOR, pickRandom((int)angle-(int)CHANGE_ANGLE,220));
        		}
        }
    }
    /* 
     * x,y = the coordinates for top left corner of a rectangle surrounding the leaf;
     * w,h = the width and height of this rectangle;
     * angle = the angle of the direction that the leaf points,
     * order = the level of the recursion.
     */
    public void drawLeaf
    (Graphics g,int x,int y,int w,int h,double angle,int order) {
    	g.setColor(LEAVES_COLORS[order]);
    	//setting colors and pos.
    	if(order==0){//yellow
    		g.fillOval(x, y, 5, 5);
    		drawLeaf(g, x+w/2, y+h, h, w, angle, ++order);
    	}
    	else if(order==2){//darkG
    		g.drawLine(x, y, x, y-h);
    		drawLeaf(g,x, y, h, w, angle, ++order);
    	}
    	else{
    		g.drawLine(x-(w/2), y-(h/2), x+(w/2), y-(h/2));
    		}
    }

    //clouds
    void drawCloud
    (Graphics page, int x, int y, int w, int h, int order)
    {
    	page.setColor(CLOUD_COLORS[pickRandom(0,2)]);
    	page.fillOval(x, y, w, h);
    	if(order < 1)
    	for(int i=0; i<pickRandom(8,10); i++){
    		drawCloud(page, x+pickRandom(0,200), y+pickRandom(0,20), w+pickRandom(0,60), h+pickRandom(0,10), ++order);
    	}
    }
    //a method that randomly picks a number between two integers
    int pickRandom(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
    public Point calculatePoint( int x, int y, double size, double degree ) {
        Point point = new Point(x, y);
        double radians = Math.PI/180 * degree;
        point.x += (int)(size * Math.sin(radians));
        point.y += (int)(size * Math.cos(radians));
        return point;
    }
}