
//더이상 사용하지 않음
//JPype가 하나의 jar밖에 인식하지 못하는 관계로
//관련코드를 Ahri_Senpai의 새로운 클래스로 이식함.

/*
package jpype.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
//import ahri_senpai.Ahri_Frame;





class Source_to_use_WEKA {
	private static int how_many_champs = 136;
	
	public Source_to_use_WEKA(){
		
	}
/*
	public static void main(String[] args) throws Exception {
		//make_csv_file();
		System.out.println("실행됨 ㅡㅡ ");
		String file_name_champ_data = "20161223_1644";
		String file_name_counterpick_data_top = "20161223_1645";
		String file_name_counterpick_data_jungle = "20161223_1645";
		String file_name_counterpick_data_mid = "20161223_1645";
		String file_name_counterpick_data_adc = "20161223_1645";
		String file_name_counterpick_data_sup = "20161223_1645";
		for_phyton(file_name_champ_data, file_name_counterpick_data_top,file_name_counterpick_data_jungle,file_name_counterpick_data_mid,file_name_counterpick_data_adc,file_name_counterpick_data_sup);
		
	}*/
	
	/*
	public void for_phyton(String file_name_champ_data, String file_name_counterpick_data_top, String file_name_counterpick_data_jungle, String file_name_counterpick_data_mid, String file_name_counterpick_data_adc, String file_name_counterpick_data_sup) throws IOException
	{
		
		String file_name_champ_data = "20161223_1644";
		String file_name_counterpick_data_top = "20161223_1645";
		String file_name_counterpick_data_jungle = "20161223_1645";
		String file_name_counterpick_data_mid = "20161223_1645";
		String file_name_counterpick_data_adc = "20161223_1645";
		String file_name_counterpick_data_sup = "20161223_1645";
		

		Ahri_Frame test = new Ahri_Frame(file_name_champ_data,file_name_counterpick_data_top,file_name_counterpick_data_jungle,file_name_counterpick_data_mid,file_name_counterpick_data_adc,file_name_counterpick_data_sup);

	}*/
	
	public void make_csv_file(String filename_champdata) throws Exception
	{
		String[][] Firstpickdata = new String[how_many_champs][6]; 
		
		
		 //////first_pick_data 읽어옴 
		String filepath = "/Users/HyeonWoo/Google 드라이브/LOLcoach/first_pick_available_csv.csv";
        CSVReader reader = new CSVReader(new FileReader(filepath));
        String[] nextLine;
        int champ_num = 0;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line

            //csv파일은 헤카림이 135(앞에 두칸 버리고 시작함)로 되있어서 인덱싱이 꼬임. 졸라 복잡함.
            for (int i=0; i<6; i++) {
                Firstpickdata[champ_num][i] = nextLine[i];
            }
            champ_num++;
        }     /*   
        for(int i=0; i<how_many_champs; i++){
        	for (int j=0; j<6; j++)
        	{
        		System.out.println(Firstpickdata[i][j]);
        	}
        }       
        //첫 인덱스는 자바챔프넘버보다 하나 작게
        //두번째 인덱스는 1탑 2정글 3미드 4원딜 5서폿
        System.out.println("하이머딩거는 정글 선픽 가능? 하이머딩거의 자바챔프넘버는 133 : " + Firstpickdata[132][2] );*/
        //////first_pick_data 읽어옴 
        
        
		System.out.println("\n\n");
		System.out.println("* 탑 선픽가능한 챔프 * ");
		process(Firstpickdata, "top", "ARFF_File_For_WEKA_top.arff", filename_champdata);
		System.out.println("\n");
		System.out.println("* 정글 선픽가능한 챔프 * ");
		process(Firstpickdata, "jungle", "ARFF_File_For_WEKA_jungle.arff", filename_champdata);
		System.out.println("\n");
		System.out.println("* 미드 선픽가능한 챔프 * ");
		process(Firstpickdata, "mid", "ARFF_File_For_WEKA_mid.arff", filename_champdata);
		System.out.println("\n");
		System.out.println("* 원딜 선픽가능한 챔프 * ");
		process(Firstpickdata, "adc", "ARFF_File_For_WEKA_adc.arff", filename_champdata);
		System.out.println("\n");
		System.out.println("* 서폿 선픽가능한 챔프 * ");
		process(Firstpickdata, "sup", "ARFF_File_For_WEKA_sup.arff", filename_champdata);
		
		
		//////first_pick_data 쓰기 
        String csv = "/Users/HyeonWoo/Google 드라이브/LOLcoach/first_pick_available_csv.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        ArrayList data = new ArrayList<String[]>();
        for (champ_num=0; champ_num<how_many_champs-1; champ_num++) {
            data.add(new String[]{
                String.valueOf(Firstpickdata[champ_num][0]).toUpperCase(),
                String.valueOf(Firstpickdata[champ_num][1]).toUpperCase(),
                String.valueOf(Firstpickdata[champ_num][2]).toUpperCase(),
                String.valueOf(Firstpickdata[champ_num][3]).toUpperCase(),
                String.valueOf(Firstpickdata[champ_num][4]).toUpperCase(),
                String.valueOf(Firstpickdata[champ_num][5]).toUpperCase()}
            );
        }
        writer.writeAll(data);
        writer.close();
        //////first_pick_data 쓰기 
	}
	
	public void say_hello_please()
	{
		System.out.println("system idiot hello!");
		//return "hello idiot!";
	}

	public static void process(String[][] Firstpickdata, String lane, String filename, String filename_champdata) throws Exception {
		int how_many_champs = 136;

		
		// 긁어온 코드에 필요한 것들 그 뭐냐 선언해줌
				Champdata[] champ_data = new Champdata[how_many_champs];
				String path = new File("").getAbsolutePath();
				//System.out.println(path);
				// 챔프데이터 초기화
				for (int i = 0; i < how_many_champs; i++) {
					champ_data[i] = new Champdata();
				}

				// csv champdata 여는 코드 긁어옴
				//champ_data_csv_20161223_1611
				String filepath = "/Users/HyeonWoo/Google 드라이브/LOLcoach/data_from_python/champ_data_csv_"+filename_champdata+".csv";
				CSVReader reader = new CSVReader(new FileReader(filepath));
				String[] nextLine;
				// 젤 윗줄(텍스트만 있음)한줄 날리고 시작함. Float으로 변환하는 과정에서 오류나기 때문에
				nextLine = reader.readNext();
				int champ_num = 2;
				while ((nextLine = reader.readNext()) != null) {
					// nextLine[] is an array of values from the line
					champ_data[champ_num].champ_name_korean = nextLine[0];
					champ_data[champ_num].top_available = new Boolean(nextLine[2]).booleanValue();
					champ_data[champ_num].jungle_available = new Boolean(nextLine[3]).booleanValue();
					champ_data[champ_num].mid_available = new Boolean(nextLine[4]).booleanValue();
					champ_data[champ_num].adc_available = new Boolean(nextLine[5]).booleanValue();
					champ_data[champ_num].sup_available = new Boolean(nextLine[6]).booleanValue();

					champ_data[champ_num].top_pick_rate = Float.parseFloat(nextLine[7]);
					champ_data[champ_num].jungle_pick_rate = Float.parseFloat(nextLine[8]);
					champ_data[champ_num].mid_pick_rate = Float.parseFloat(nextLine[9]);
					champ_data[champ_num].adc_pick_rate = Float.parseFloat(nextLine[10]);
					champ_data[champ_num].sup_pick_rate = Float.parseFloat(nextLine[11]);
					champ_data[champ_num].winning_rate_top = Float.parseFloat(nextLine[12]);
					champ_data[champ_num].winning_rate_jungle = Float.parseFloat(nextLine[13]);
					champ_data[champ_num].winning_rate_mid = Float.parseFloat(nextLine[14]);
					champ_data[champ_num].winning_rate_adc = Float.parseFloat(nextLine[15]);
					champ_data[champ_num].winning_rate_sup = Float.parseFloat(nextLine[16]);
					champ_data[champ_num].top_ratio = Float.parseFloat(nextLine[17]);
					champ_data[champ_num].jungle_ratio = Float.parseFloat(nextLine[18]);
					champ_data[champ_num].mid_ratio = Float.parseFloat(nextLine[19]);
					champ_data[champ_num].adc_ratio = Float.parseFloat(nextLine[20]);
					champ_data[champ_num].sup_ratio = Float.parseFloat(nextLine[21]);

					// 뒷부분 더 추가해야됨
					champ_data[champ_num].deal_steady = new Boolean(nextLine[22]).booleanValue();
					champ_data[champ_num].deal_nuke = new Boolean(nextLine[23]).booleanValue();
					champ_data[champ_num].tank = new Boolean(nextLine[24]).booleanValue();
					champ_data[champ_num].deal_and_tank = new Boolean(nextLine[25]).booleanValue();

					champ_data[champ_num].initiating = new Boolean(nextLine[26]).booleanValue();
					champ_data[champ_num].counter_initiating_ult = new Boolean(nextLine[27]).booleanValue();

					champ_data[champ_num].ad = new Boolean(nextLine[28]).booleanValue();
					champ_data[champ_num].ap = new Boolean(nextLine[29]).booleanValue();
					champ_data[champ_num].hybrid = new Boolean(nextLine[30]).booleanValue();

					champ_data[champ_num].dash_skill = new Boolean(nextLine[31]).booleanValue();
					champ_data[champ_num].escape_skill = new Boolean(nextLine[32]).booleanValue();

					champ_data[champ_num].meele_attack = new Boolean(nextLine[33]).booleanValue();
					champ_data[champ_num].ranged_attack = new Boolean(nextLine[34]).booleanValue();

					champ_data[champ_num].poking = new Boolean(nextLine[35]).booleanValue();
					champ_data[champ_num].line_clear = new Boolean(nextLine[36]).booleanValue();
					champ_data[champ_num].hard_cc = new Boolean(nextLine[37]).booleanValue();
					champ_data[champ_num].hide = new Boolean(nextLine[38]).booleanValue();
					champ_data[champ_num].global_ult = new Boolean(nextLine[39]).booleanValue();
					champ_data[champ_num].heal = new Boolean(nextLine[40]).booleanValue();
					champ_data[champ_num].shield = new Boolean(nextLine[41]).booleanValue();
					champ_data[champ_num].protect = new Boolean(nextLine[42]).booleanValue();

					champ_data[champ_num].self_shield = new Boolean(nextLine[43]).booleanValue();
					champ_data[champ_num].self_heal = new Boolean(nextLine[44]).booleanValue();
					champ_data[champ_num].ranged_no_cost_skill = new Boolean(nextLine[45]).booleanValue();

					champ_data[champ_num].range = Integer.parseInt(nextLine[46]);
					
					champ_data[champ_num].counter_initiating_skill = new Boolean(nextLine[47]).booleanValue();

					champ_num++;
				}

				int how_many_champs_in_this_lane = 0;

				// 현재 라인에 존재하는 챔프수 불러와야함.

						if (lane.contains("top")) {
							for (int i = 2; i < how_many_champs; i++) {
								if (champ_data[i].top_available == true && champ_data[i].top_pick_rate != 0)
									how_many_champs_in_this_lane++;
							}
						}
						if (lane.contains("jungle")) {
							for (int i = 2; i < how_many_champs; i++) {
								if (champ_data[i].jungle_available == true && champ_data[i].jungle_pick_rate != 0)
									how_many_champs_in_this_lane++;
							}
						}
						if (lane.contains("mid")) {
							for (int i = 2; i < how_many_champs; i++) {
								if (champ_data[i].mid_available == true && champ_data[i].mid_pick_rate != 0)
									how_many_champs_in_this_lane++;
							}
						}
						if (lane.contains("adc")) {
							for (int i = 2; i < how_many_champs; i++) {
								if (champ_data[i].adc_available == true && champ_data[i].adc_pick_rate != 0)
									how_many_champs_in_this_lane++;
							}
						}
						if (lane.contains("sup")) {
							for (int i = 2; i < how_many_champs; i++) {
								if (champ_data[i].sup_available == true && champ_data[i].sup_pick_rate != 0)
									how_many_champs_in_this_lane++;
							}
						}
		
		
		
		// TODO Auto-generated method stub
		// The DataSource class is not limited to ARFF files. (3.5.5 and newer)
		// It can also read CSV files and other formats (basically all file
		// formats that Weka can import via its converters using the gui.

		DataSource source = new DataSource("/Users/HyeonWoo/Google 드라이브/LOLcoach/data_from_python/" + filename);
		//DataSource source = new DataSource("/Users/HyeonWoo/Downloads/"+ filename);

		// convert the data to "Instances" instances
		Instances data = source.getDataSet();
		// 첫번째 데이터(string)무시
		// data.remove(0);

		// The option string is generated using the WEKA GUI
		// String Options="-init 0 -max-candidates 100 -periodic-pruning 10000
		// -min-density 2.0 -t1 -1.25 -t2 -1.0 -N 10 -A
		// \"weka.core.EuclideanDistance -R first-last\" -I 500 -num-slots 1 -S
		// 10";
		String Options = "-init 0 -max-candidates 100 -periodic-pruning 10000 -min-density 2.0 -t1 -1.25 -t2 -1.0 -N 20 -A \"weka.core.EuclideanDistance -R first-last\" -I 500 -num-slots 1 -S 10";

		SimpleKMeans kmean = new SimpleKMeans();
		kmean.setOptions(weka.core.Utils.splitOptions(Options));

		kmean.buildClusterer(data);

		int num_of_clusters = kmean.getNumClusters();

		String string = kmean.toString();
		String[] Array1 = string.split("\n");
		String[][] Array2 = new String[Array1.length - 26][num_of_clusters];

		// 인덱스 26일때부터 데이터 시작함(가렌승률)
		// 전체 길이는 가변임 라인(탑,정글,미드,원딜,서폿)에 따라 챔프 개수가 다르기 때문에
		// 26 ~ Array.length 로 잡으면 될듯.
		for (int i = 26; i < Array1.length; i++) {
			//System.out.println("지금 index는 " + i);
			//System.out.println(Array1[i]);

			Pattern p = Pattern.compile("[  ]+");
			Array1[i] = p.matcher(Array1[i]).replaceAll(" ");
			//System.out.println(Array1[i]);

			Array2[i - 26] = Array1[i].split(" ");

		}

		// 앞부분이 속성
		// 속성값은 0 ~ Arrya1.length-26-1까지 있다.
		// 뒷부분은 클러스터 인덱스. 0 ~ number_of_clusters+2까지 있다.
		//System.out.println("Array2 검사 ");
		for (int i = 0; i < num_of_clusters + 2; i++) {
			//System.out.println(Array2[Array1.length - 26 - 1][i]);
		}
		// Array2에 각 클러스터의 특성이 모두 들어감.

		// 테스트코드
		// 각 인스턴스(챔프)가 몇번 클러스터에 속하는지를 알아냄.
		// we get the 6th instance (line)
		
		for (int i = 0; i < how_many_champs_in_this_lane; i++) {
			// System.out.println("champ number " + data.instance(i) + "는 클러스터" +kmean.clusterInstance(data.get(i)) + "에 속함(전체)");

			// 인스턴스 data의 i번째 instance를 불러와서 0번째 stringValue를 출
			 //System.out.println(data.instance(i).stringValue(0) + "는 클러스터 "
			// +kmean.clusterInstance(data.get(i)) + "에 속함(부분)"
			// + "클러스터" + kmean.clusterInstance(data.get(i)));
		}

		// 이제 선픽 가능한 챔프를 걸러내야 하는데...

		// 오피지지승률 50넘는 클러스터 찾아냄.
		// 클러스터 인덱스는 0~kmean.getNumCluster() 까지 있다. getNumCluster()자체가 클러스터 개수고,
		// 인덱스는 그것보다 하나 작음(배열의 특성)

		// 서포터랑 정글은 특성의 개수가 다르기 때문에, 인덱스도 달라야 한다
		// 탑은 Array2[Array1.length-26-1-5][i+2]) >= 50)
		// 서포터는 Array2[Array1.length-26-1-2][i+2]) >= 50
		// 원딜은 Array2[Array1.length-26-1-5][i+2]) >= 50)
		boolean[] Cluster_winrate_over_50 = new boolean[kmean.getNumClusters()];
		int temp = 0;
		if (lane.contains("top") || lane.contains("mid") || lane.contains("adc"))
			temp = 5;
		if (lane.contains("jungle"))
			temp = 4;
		if (lane.contains("sup"))
			temp = 2;

		for (int i = 0; i < kmean.getNumClusters(); i++) {
			//System.out.println("클러스터 " + i + "의 승률 : " + Array2[Array1.length - 26 - 1 - temp][i + 2]);
			if (Float.parseFloat(Array2[Array1.length - 26 - 1 - temp][i + 2]) >= 50) {
				Cluster_winrate_over_50[i] = true;
				//System.out.println("클러스터 " + i + "는 승률 50이상 ");
		
			} else
				Cluster_winrate_over_50[i] = false;
		}

		// 챔프 개수 다른 파일에서 받아오게끔 코드 수정해야한다.
		// 아마 챔프데이터에서 line_available로 받고, 거기서 주관적인 특성들까지 같이 가져오면 될듯.

		

		// 인스턴스를 불러와서, 50이상 + 지정한 조건을 만족하면 출력.
		for (int i = 0; i < how_many_champs_in_this_lane; i++) {
			if (Cluster_winrate_over_50[kmean.clusterInstance(data.get(i))] == true) {
				
				if (lane.contains("top")) {
					if ((champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].self_shield == true
							//|| champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].self_heal == true
							|| champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].ranged_attack == true
							|| champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].ranged_no_cost_skill == true)
							&& champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].winning_rate_top >= 50
							) {
						System.out.println(data.instance(i).stringValue(0) + " : 선픽가능 ");
						Firstpickdata[Champ_name_to_champ_number(data.instance(i).stringValue(0))-1][1] = "TRUE";
					}
				}
				if (lane.contains("jungle")) {
					if (champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].winning_rate_jungle >= 50) {
						System.out.println(data.instance(i).stringValue(0) + " : 선픽가능 ");
						Firstpickdata[Champ_name_to_champ_number(data.instance(i).stringValue(0))-1][2] = "TRUE";
						//System.out.println(data.instance(i).stringValue(0) + "의 정글 승률 : " + champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].winning_rate_jungle);
					}
				}
				if (lane.contains("mid")) {
					if ((champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].line_clear == true
							&& champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].ranged_attack == true)
							&& champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].winning_rate_mid >= 50
							) {
						System.out.println(data.instance(i).stringValue(0) + " : 선픽가능 ");
						Firstpickdata[Champ_name_to_champ_number(data.instance(i).stringValue(0))-1][3] = "TRUE";
					}
				}
				if (lane.contains("adc")) {
					if ((champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].deal_nuke == true
							|| champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].range >= 550)
							&& champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].winning_rate_adc >= 50) {
						System.out.println(data.instance(i).stringValue(0) + " : 선픽가능 ");
						Firstpickdata[Champ_name_to_champ_number(data.instance(i).stringValue(0))-1][4] = "TRUE";
					}
				}
				if (lane.contains("sup")) {
					if ((champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].ranged_attack == true	
							&& champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].counter_initiating_skill == true)
							&& champ_data[Champ_name_to_champ_number(data.instance(i).stringValue(0))].winning_rate_sup >= 50) {
						System.out.println(data.instance(i).stringValue(0) + " : 선픽가능 ");
						Firstpickdata[Champ_name_to_champ_number(data.instance(i).stringValue(0))-1][5] = "TRUE";
					}
				}
			}
			// 인스턴스 data의 i번째 instance를 불러와서 0번째 stringValue를 출
			// System.out.println(data.instance(i).stringValue(0) + "는 클러스터 "
			// +kmean.clusterInstance(data.get(i)) + "에 속함(부분)"
			// + "클러스터" + kmean.clusterInstance(data.get(i)));
		}

	}// 메인의 끝부분

	static int Champ_name_to_champ_number(String name) {
		if (name.contains("가렌"))
			return 2;
		if (name.contains("갈리오"))
			return 3;
		if (name.contains("갱플랭크"))
			return 4;
		if (name.contains("그라가스"))
			return 5;
		if (name.contains("그레이브즈"))
			return 6;
		if (name.contains("나르"))
			return 7;
		if (name.contains("나미"))
			return 8;
		if (name.contains("나서스"))
			return 9;
		if (name.contains("노틸러스"))
			return 10;
		if (name.contains("녹턴"))
			return 11;
		if (name.contains("누누"))
			return 12;
		if (name.contains("니달리"))
			return 13;
		if (name.contains("다리우스"))
			return 14;
		if (name.contains("다이애나"))
			return 15;
		if (name.contains("드레이븐"))
			return 16;
		if (name.contains("라이즈"))
			return 17;
		if (name.contains("람머스"))
			return 18;
		if (name.contains("럭스"))
			return 19;
		if (name.contains("럼블"))
			return 20;
		if (name.contains("레넥톤"))
			return 21;
		if (name.contains("레오나"))
			return 22;
		if (name.contains("렉사이"))
			return 23;
		if (name.contains("렝가"))
			return 24;
		if (name.contains("루시안"))
			return 25;
		if (name.contains("룰루"))
			return 26;
		if (name.contains("르블랑"))
			return 27;
		if (name.contains("리신"))
			return 28;
		if (name.contains("리븐"))
			return 29;
		if (name.contains("리산드라"))
			return 30;
		if (name.contains("마스터이"))
			return 31;
		if (name.contains("마오카이"))
			return 32;
		if (name.contains("말자하"))
			return 33;
		if (name.contains("말파이트"))
			return 34;
		if (name.contains("모데카이저"))
			return 35;
		if (name.contains("모르가나"))
			return 36;
		if (name.contains("문도박사"))
			return 37;
		if (name.contains("미스포츈"))
			return 38;
		if (name.contains("바드"))
			return 39;
		if (name.contains("바루스"))
			return 40;
		if (name.contains("바이"))
			return 41;
		if (name.contains("베이가"))
			return 42;
		if (name.contains("베인"))
			return 43;
		if (name.contains("벨코즈"))
			return 44;
		if (name.contains("볼리베어"))
			return 45;
		if (name.contains("브라움"))
			return 46;
		if (name.contains("브랜드"))
			return 47;
		if (name.contains("블라디미르"))
			return 48;
		if (name.contains("블리츠크랭크"))
			return 49;
		if (name.contains("빅토르"))
			return 50;
		if (name.contains("뽀삐"))
			return 51;
		if (name.contains("사이온"))
			return 52;
		if (name.contains("샤코"))
			return 53;
		if (name.contains("세주아니"))
			return 54;
		if (name.contains("소나"))
			return 55;
		if (name.contains("소라카"))
			return 56;
		if (name.contains("쉔"))
			return 57;
		if (name.contains("쉬바나"))
			return 58;
		if (name.contains("스웨인"))
			return 59;
		if (name.contains("스카너"))
			return 60;
		if (name.contains("시비르"))
			return 61;
		if (name.contains("신짜오"))
			return 62;
		if (name.contains("신드라"))
			return 63;
		if (name.contains("신지드"))
			return 64;
		if (name.contains("쓰레쉬"))
			return 65;
		if (name.contains("아리"))
			return 66;
		if (name.contains("아무무"))
			return 67;
		if (name.contains("아우렐리온솔"))
			return 68;
		if (name.contains("아이번"))
			return 69;
		if (name.contains("아지르"))
			return 70;
		if (name.contains("아칼리"))
			return 71;
		if (name.contains("아트록스"))
			return 72;
		if (name.contains("알리스타"))
			return 73;
		if (name.contains("애니"))
			return 74;
		if (name.contains("애니비아"))
			return 75;
		if (name.contains("애쉬"))
			return 76;
		if (name.contains("야스오"))
			return 77;
		if (name.contains("에코"))
			return 78;
		if (name.contains("엘리스"))
			return 79;
		if (name.contains("오공"))
			return 80;
		if (name.contains("오리아나"))
			return 81;
		if (name.contains("올라프"))
			return 82;
		if (name.contains("요릭"))
			return 83;
		if (name.contains("우디르"))
			return 84;
		if (name.contains("우르곳"))
			return 85;
		if (name.contains("워윅"))
			return 86;
		if (name.contains("이렐리아"))
			return 87;
		if (name.contains("이블린"))
			return 88;
		if (name.contains("이즈리얼"))
			return 89;
		if (name.contains("일라오이"))
			return 90;
		if (name.contains("자르반4세"))
			return 91;
		if (name.contains("자이라"))
			return 92;
		if (name.contains("자크"))
			return 93;
		if (name.contains("잔나"))
			return 94;
		if (name.contains("잭스"))
			return 95;
		if (name.contains("제드"))
			return 96;
		if (name.contains("제라스"))
			return 97;
		if (name.contains("제이스"))
			return 98;
		if (name.contains("직스"))
			return 99;
		if (name.contains("진"))
			return 100;
		if (name.contains("질리언"))
			return 101;
		if (name.contains("징크스"))
			return 102;
		if (name.contains("초가스"))
			return 103;
		if (name.contains("카르마"))
			return 104;
		if (name.contains("카사딘"))
			return 105;
		if (name.contains("카서스"))
			return 106;
		if (name.contains("카시오페아"))
			return 107;
		if (name.contains("카직스"))
			return 108;
		if (name.contains("카타리나"))
			return 109;
		if (name.contains("칼리스타"))
			return 110;
		if (name.contains("케넨"))
			return 111;
		if (name.contains("케이틀린"))
			return 112;
		if (name.contains("케일"))
			return 113;
		if (name.contains("코그모"))
			return 114;
		if (name.contains("코르키"))
			return 115;
		if (name.contains("퀸"))
			return 116;
		if (name.contains("클레드"))
			return 117;
		if (name.contains("킨드레드"))
			return 118;
		if (name.contains("타릭"))
			return 119;
		if (name.contains("탈론"))
			return 120;
		if (name.contains("탈리야"))
			return 121;
		if (name.contains("탐켄치"))
			return 122;
		if (name.contains("트런들"))
			return 123;
		if (name.contains("트리스타나"))
			return 124;
		if (name.contains("트린다미어"))
			return 125;
		if (name.contains("트위스티드페이트"))
			return 126;
		if (name.contains("트위치"))
			return 127;
		if (name.contains("티모"))
			return 128;
		if (name.contains("판테온"))
			return 129;
		if (name.contains("피들스틱"))
			return 130;
		if (name.contains("피오라"))
			return 131;
		if (name.contains("피즈"))
			return 132;
		if (name.contains("하이머딩거"))
			return 133;
		if (name.contains("헤카림"))
			return 134;
		else
			return 0;

	}
}

class Champdata {

    String champ_name_korean;

    boolean top_available;
    boolean jungle_available;
    boolean mid_available;
    boolean adc_available;
    boolean sup_available;

    //from op.gg
    float top_pick_rate;
    float jungle_pick_rate;
    float mid_pick_rate;
    float adc_pick_rate;
    float sup_pick_rate;
    float winning_rate_top;
    float winning_rate_jungle;
    float winning_rate_mid;
    float winning_rate_adc;
    float winning_rate_sup;
    float top_ratio;
    float jungle_ratio;
    float mid_ratio;
    float adc_ratio;
    float sup_ratio;

    boolean deal_steady;
    boolean deal_nuke;
    boolean tank;
    boolean deal_and_tank;

    boolean initiating;
    boolean counter_initiating_ult;

    boolean ad;
    boolean ap;
    boolean hybrid;

    boolean dash_skill;
    boolean escape_skill;

    boolean meele_attack;
    boolean ranged_attack;

    boolean poking;
    boolean line_clear;
    boolean hard_cc;
    boolean hide;
    boolean global_ult;
    boolean heal;
    boolean shield;
    boolean protect;
    
    boolean self_shield;
    boolean self_heal;
    boolean ranged_no_cost_skill;
    
    int range;
    
    boolean counter_initiating_skill;

    public Champdata() {

        champ_name_korean = "";

        top_available = false;
        jungle_available = false;
        mid_available = false;
        adc_available = false;
        sup_available = false;

        //from op.gg
        top_pick_rate = 0;
        jungle_pick_rate = 0;
        mid_pick_rate = 0;
        adc_pick_rate = 0;
        sup_pick_rate = 0;
        winning_rate_top = 0;
        winning_rate_jungle = 0;
        winning_rate_mid = 0;
        winning_rate_adc = 0;
        winning_rate_sup = 0;
        top_ratio = 0;
        jungle_ratio = 0;
        mid_ratio = 0;
        adc_ratio = 0;
        sup_ratio = 0;

        deal_steady = false;
        deal_nuke = false;
        tank = false;
        deal_and_tank = false;

        initiating = false;
        counter_initiating_ult = false;

        ad = false;
        ap = false;
        hybrid = false;

        dash_skill = false;
        escape_skill = false;

        meele_attack = false;
        ranged_attack = false;

        poking = false;
        line_clear = false;
        hard_cc = false;
        hide = false;
        global_ult = false;
        heal = false;
        shield = false;
        protect = false;
        
        self_shield = false;
        self_heal = false;
        ranged_no_cost_skill = false;
        
        range = 0;
        
        counter_initiating_skill = false;
    }
    
    */
