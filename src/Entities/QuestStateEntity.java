package Entities;

import javax.persistence.*;

@SuppressWarnings("UnusedDeclaration")
@Entity
@Table(name="QuestStates")
public class QuestStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestStateID")
    private int questStateID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "QuestID", updatable = false, insertable = false)
    private QuestEntity quest;

    @Column(name = "Sequence")
    private int sequence;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "QuestTypeID", updatable = false, insertable = false)
    private QuestTypeEntity questType;

    @Column(name = "JournalStateID")
    private int journalStateID;

    @Column(name = "IsFinalState")
    private boolean isFinalState;

    public int getQuestStateID() {
        return questStateID;
    }

    public void setQuestStateID(int questStateID) {
        this.questStateID = questStateID;
    }

    public QuestEntity getQuest() {
        return quest;
    }

    public void setQuest(QuestEntity quest) {
        this.quest = quest;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public QuestTypeEntity getQuestType() {
        return questType;
    }

    public void setQuestType(QuestTypeEntity questType) {
        this.questType = questType;
    }

    public int getJournalStateID() {
        return journalStateID;
    }

    public void setJournalStateID(int journalStateID) {
        this.journalStateID = journalStateID;
    }

    public boolean isFinalState() {
        return isFinalState;
    }

    public void setFinalState(boolean finalState) {
        isFinalState = finalState;
    }
}
