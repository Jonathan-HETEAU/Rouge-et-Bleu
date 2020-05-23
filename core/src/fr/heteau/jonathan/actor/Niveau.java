package fr.heteau.jonathan.actor;


import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;




public class Niveau implements Json.Serializable {

	public static class Position implements Json.Serializable{
		public int x;
		public int y;
		@Override
		public void write(Json json) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void read(Json json, JsonValue jsonData) {
			
			x = jsonData.getInt("x");
			y = jsonData.getInt("y");
		}
	}
	
	public static class NCaisse implements Json.Serializable{
		public Position pos;
		public int[] connection ;
		@Override
		public void write(Json json) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void read(Json json, JsonValue jsonData) {
			
			pos  = json.fromJson(Position.class, jsonData.get("p").toString()); 
			connection= jsonData.get("c").asIntArray(); 
			
		}
	}
	
	public static class Arene implements Json.Serializable{
		public Position BaliseFin ;
		public NCaisse[] Caisse ;
		public Position[] Block ;
		public Position Oeil ;
		
		@Override
		public void write(Json json) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void read(Json json, JsonValue jsonData) {
			BaliseFin = json.fromJson(Position.class, jsonData.get("BaliseFin").toString() );
			Oeil = json.fromJson(Position.class, jsonData.get("Oeil").toString() ); 
			
			JsonValue jvC = jsonData.get("Caisses");
			if( jvC != null )
			{	Caisse = new NCaisse[jvC.size];
				int i= 0;
				
				for( JsonValue jv : jvC){
					
					Caisse[i]= json.fromJson(NCaisse.class, jv.toString() );
					i++;
				}
			}
			else
				Caisse = new NCaisse[0];
			
			jvC = jsonData.get("Blocks");
			if( jvC != null )
			{	
				Block = new Position[jvC.size];
				int i= 0;
				for( JsonValue jv : jvC){
					Block[i]= json.fromJson(Position.class, jv.toString() );
					i++;
				}
			}
			else
				Block = new Position[0];
			
			
		}
	}
	
	public Arene bleu;
	public Arene rouge;
	
	boolean sens;
	
	public Niveau() {
		this.sens =  MathUtils.randomBoolean(); 
			
	}
	
	public void charger( WorldArene bleu , WorldArene rouge , World world){
				
		if( sens){
			chargerArene(bleu, rouge, this.bleu, world);
			chargerArene(rouge,bleu , this.rouge, world);
		}else{
			chargerArene(bleu, rouge, this.rouge, world);
			chargerArene(rouge,bleu , this.bleu, world);
		}
		
	}
	
	private void chargerArene( WorldArene wArene1 , WorldArene wArene2, Arene nArene ,World world){
		
		wArene1.baliseFin.setPosition(wArene1.getX()+nArene.BaliseFin.x, wArene1.getY()+nArene.BaliseFin.y);
		wArene1.oeil.setPosition(wArene1.getX()+nArene.Oeil.x, wArene1.getY()+nArene.Oeil.y);
		wArene1.mBlock = new Block[nArene.Block.length];
		for(int i = 0 ; i < nArene.Block.length ; i ++){
			wArene1.mBlock[i]= new Block(wArene1,wArene1.getX()+nArene.Block[i].x , wArene1.getY()+nArene.Block[i].y);
		}
		wArene1.mCaises = new Caisse[nArene.Caisse.length];
		for(int i = 0 ; i < nArene.Caisse.length ; i ++){
			wArene1.mCaises[i]= new Caisse(i, wArene1, wArene2, nArene.Caisse[i].connection,wArene1.getX()+nArene.Caisse[i].pos.x, wArene1.getY() + nArene.Caisse[i].pos.y);
		}
	}
	
	public void restart(WorldArene bleu , WorldArene rouge , World world){
		
		if( sens){
			restartArene(bleu, this.bleu, world);
			restartArene(rouge,this.rouge, world);
		}else{
			restartArene(bleu, this.rouge, world);
			restartArene(rouge,this.bleu, world);
		}
	}

	private void restartArene(WorldArene wArene1 , Arene nArene ,World world) {
		
		wArene1.baliseFin.setPosition(wArene1.getX()+nArene.BaliseFin.x, wArene1.getY()+nArene.BaliseFin.y);
		wArene1.oeil.setPosition(wArene1.getX()+nArene.Oeil.x, wArene1.getY()+nArene.Oeil.y);
		wArene1.oeil.deSelect();
		for(int i = 0 ; i < nArene.Block.length ; i ++){
			wArene1.mBlock[i].setPosition(wArene1.getX()+nArene.Block[i].x , wArene1.getY()+nArene.Block[i].y);
		}
	
		for(int i = 0 ; i < nArene.Caisse.length ; i ++){
			wArene1.mCaises[i].setPosition(wArene1.getX()+nArene.Caisse[i].pos.x, wArene1.getY() + nArene.Caisse[i].pos.y);
			wArene1.mCaises[i].setBalise(false);
			wArene1.mCaises[i].setPower(false);
		}
		
	}

	@Override
	public void write(Json json) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		// TODO Auto-generated method stub
		bleu  = json.fromJson(Arene.class, jsonData.get("Arene1").toString()); 
		rouge = json.fromJson(Arene.class, jsonData.get("Arene2").toString()); 
	}
	
	
}
