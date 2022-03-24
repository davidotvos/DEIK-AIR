package hu.unideb.inf.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAnimalDAO implements AnimalDAO{

    private List<Animal> animals;

    public FileAnimalDAO(){
        try(FileInputStream fis = new FileInputStream("animals.ser");
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            animals = (List<Animal>)ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            animals = new ArrayList<>();
        }
    }

    @Override
    public void saveAnimal(Animal a) {
        animals.add(a);
        try(FileOutputStream fos = new FileOutputStream("animals.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(animals);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAnimal(Animal a) {
        animals.remove(a);
        try(FileOutputStream fos = new FileOutputStream("animals.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(animals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAnimal(Animal a) {
        int idx = animals.indexOf(a);
        if(idx == -1)
        {
            saveAnimal(a);
            return;
        }
        else
        {
            animals.remove(idx);
            animals.add(a);
        }
        try(FileOutputStream fos = new FileOutputStream("animals.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(animals);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void saveZoo(Zoo zoo) {

    }

    @Override
    public void close() throws Exception {

    }
}
