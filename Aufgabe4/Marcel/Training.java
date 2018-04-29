// Marcel Steger

import java.util.*;


public class Training {
	// Instanzvariablen zum Verwalten der Trainings

	// HashMap mit Key und Liste
	private HashMap<String, ArrayList<Double>> training;
	// private Set<String> names = training.
	// private Set<String> names;

	// get Keys
	public Set<String> getKeys() {
		return this.training.keySet();
	}
	// Constructor
	public Training() {
		// Erstelle leere HashMap und setze keys
		this.training = new HashMap<>();
		// this.names = this.getKeys();
	}
	// eine weitere Trainingszeit zum gegebenen Namen hinzufügen
	public void addTraining(String K, double V) {
		ArrayList<Double> trainingList = new ArrayList<>();
		// Wenn Name noch nicht vorhanden in HashMap, dann lege eine Liste an:
		if (!training.containsKey(K)) {
			// Key nicht enthalten, also neue Liste anlegen

			trainingList.add(V);

		}
		if (training.containsKey(K)) {
			// get training of key K
			trainingList = training.get(K);
			if (!trainingList.contains(V)) {
				trainingList.add(V);
			}
		}

		training.put(K, trainingList);
		// training.put(K, new ArrayList<Double>());

	}
	public String toString(String K) {
		String time = this.training.get(K).toString();

		return K + ": \n" + time;
	}
	// liefert die Liste aller Trainingszeiten des gegebenen Namens
	public ArrayList<Double> getAll(String K) {
		return training.get(K);
	}
	// liefert die durchschnittliche Trainingszeit zum gegebenen Namen
	public double getAverage(String K) {
		double sum = 0.0;
		if (this.size(K) == 0) {
			return sum;
		} else {
			// loop over elements:
			for (double el : this.getAll(K)) {
				sum = sum + el;
			}
		}
		return sum / this.size(K);
	}
	// liefert die minimale Trainingszeit zum gegegenen Namen
	public double getMin(String K) {
		double min = 9999999999.9;
		if (this.size(K) > 0) {
			for (double el : this.getAll(K)) {
				if (el < min) {
					min = el;
				}
			}
		}
		return min;
	}
	// liefert die maximale Trainingszeit zum gegeben Namen
	public double getMax(String K) {
		double max = 0.0;
		if (this.size(K) > 0) {
			for (double el : this.getAll(K)) {
				if (el > max) {
					max = el;
				}
			}
		}
		return max;
	}
	// Anzahl der eingetragenen Namen
	public int size(String K) {
		return training.get(K).size();
	}
	// liefert maximale Trainingszeit aller eingetragenen Zeiten // zu allen Namen
	 public double getOverallMax () {
		 double allMax = 0.0;
		 if(this.training.size() == 0) return allMax;
//		 
		 
//		 for(ArrayList<Double> value: this.training.values()) {
		 for(String key: this.getKeys()) {
			 if(this.getMax(key) > allMax) {
				 //if max of current list, is bigger than allTime Maxium so far, replace it
				 allMax = this.getMax(key);
			 }

		 }
		 return allMax;
	 }
	}
