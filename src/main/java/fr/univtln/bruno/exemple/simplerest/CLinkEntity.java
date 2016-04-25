package fr.univtln.bruno.exemple.simplerest;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mpesnel786 on 25/04/16.
 */
public class CLinkEntity {
    @Id
    @Column(name = "link_id")
    private int mId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_fk")
    @JsonIgnore
    private CFieldEntity mField;
    //TODO  manytoone portal1 portal2

    public CLinkEntity() {}

    public CLinkEntity(CLinkBuilder pBuilder){
        mId = pBuilder.mId;
    }

    public static class CLinkBuilder{
        private int mId;

        public CLinkBuilder(int pId) {
            mId = pId;
        }

        public CLinkEntity build(){
            return new CLinkEntity((this));
        }
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public CFieldEntity getmField() {
        return mField;
    }

    public void setmField(CFieldEntity mField) {
        this.mField = mField;
    }
}
