package fr.univtln.bruno.exemple.simplerest;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpesnel786 on 25/04/16.
 */

@Entity
//@Table(name = "tterritory" , schema = "project")
public class CTerritoryEntity implements Serializable{
    @Id
    @Column(name = "territory_id")
    private int mId;
    @OneToMany(mappedBy="mTerritory")
    @JsonIgnore
    private List<CFieldEntity> mFields = new ArrayList<CFieldEntity>();

    public CTerritoryEntity() {}

    public CTerritoryEntity(CTerritoryBuilder pBuilder){
        mId = pBuilder.mId;
    }

    public static class CTerritoryBuilder{
        private int mId;

        public CTerritoryBuilder(int pId) {
            mId = pId;
        }

        public CTerritoryEntity build(){
            return new CTerritoryEntity((this));
        }

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    @JsonIgnore
    public List<CFieldEntity> getmFields() {
        return mFields;
    }

    public void addmFields(CFieldEntity pField){
        mFields.add(pField);
        pField.setmTerritory(this);
    }

    public void delmFields(CFieldEntity pField){
        mFields.remove(pField);
        pField.setmTerritory(null);
    }

}
