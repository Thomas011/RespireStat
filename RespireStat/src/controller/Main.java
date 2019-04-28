package controller;
import model.Etablissement;
import view.Viewer;
import java.util.List;
import java.util.Map;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		//Viewer viewer = new Viewer("RespireStat");
		ConvertCSV build = new ConvertCSV();
		List<Etablissement> Collections = build.Run_CSV("./src/ecoles-creches-idf.csv");
		
		Stat_Etablissements test = new Stat_Etablissements(Collections);
		List<Etablissement> FO1 = test.Get_FO1();
	}
}
