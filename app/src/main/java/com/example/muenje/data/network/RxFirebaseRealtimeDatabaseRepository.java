package com.example.muenje.data.network;

import com.example.muenje.data.entities.QuestionSet;
import com.example.muenje.data.network.pojo.FullLessonResponse;
import com.example.muenje.data.network.pojo.FullQuizResponse;
import com.example.muenje.data.network.pojo.LessonTitleResponse;
import com.example.muenje.data.network.pojo.QuestionSetResponse;
import com.example.muenje.data.network.pojo.QuizTitleResponse;
import com.example.muenje.data.network.pojo.SingleAchievementResponse;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Maybe;

public class RxFirebaseRealtimeDatabaseRepository {

    FirebaseDatabase mFirebaseDatabase;

    public RxFirebaseRealtimeDatabaseRepository(FirebaseDatabase firebaseDatabase) {
        mFirebaseDatabase = firebaseDatabase;
    }

    public Maybe<List<LessonTitleResponse>> getLessonsTitles() {
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getLectionTitleReference());
        return RxFirebaseDatabase.observeSingleValueEvent(query,
                (dataSnapshot -> {
                    ArrayList<LessonTitleResponse> lectionsTitlesArrayList = new ArrayList<>();
                    for (DataSnapshot dataSnapshotLectionTitles : dataSnapshot.getChildren()) {
                        lectionsTitlesArrayList.add(dataSnapshotLectionTitles.getValue(LessonTitleResponse.class));
                    }
                    return lectionsTitlesArrayList;
                }));
    }

    public Maybe<FullLessonResponse> getFullLesson(Integer id){
        final Query query =mFirebaseDatabase.getReference(referenceNotes.getFullLectionReference(id));
        return RxFirebaseDatabase.observeSingleValueEvent(query,
                (dataSnapshot -> dataSnapshot.getValue(FullLessonResponse.class)));
    }

    public Maybe<List<QuizTitleResponse>> getQuizTitles(){
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getFullQuizTitleReference());
        return RxFirebaseDatabase.observeSingleValueEvent(query,(dataSnapshot -> {
            ArrayList<QuizTitleResponse> quizTitlesArrayList = new ArrayList<>();
            for (DataSnapshot dataSnapshotQuizTitles : dataSnapshot.getChildren()) {
                quizTitlesArrayList.add(dataSnapshotQuizTitles.getValue(QuizTitleResponse.class));
            }
            return quizTitlesArrayList;
        }));
    }

    public Maybe<FullQuizResponse> getFullQuiz(Integer quizId){
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getFullQuizReference(quizId));
        return RxFirebaseDatabase.observeSingleValueEvent(query,FullQuizResponse.class);
    }

    public Maybe<List<SingleAchievementResponse>> getUsersAchievements(String username){
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getAchievementsReference(username));
        return RxFirebaseDatabase.observeSingleValueEvent(query,(dataSnapshot -> {
            ArrayList<SingleAchievementResponse> achievementResponseArrayList = new ArrayList<>();
            for (DataSnapshot dataSnapshotSingleAchievement : dataSnapshot.getChildren()){
                achievementResponseArrayList.add(dataSnapshotSingleAchievement.getValue(SingleAchievementResponse.class));
            }
            return achievementResponseArrayList;
        }));
    }

    public void setLessonReed(String username,String lessonId){
        mFirebaseDatabase
                .getReference(referenceNotes.getLessonReedReference(username,lessonId))
                .setValue(true);
    }

    private static class referenceNotes {
        final static String challenges = "challenges";
        final static String lessons = "lessons";
        final static String quizzes = "quizzes";
        final static String titles = "titles";
        final static String full = "full";

        final static String achievements = "achievements";
        final static String lesson = "lesson";
        final static String isAchieved = "isAchieved";

        public static String getLectionTitleReference() {
            return referenceNotes.challenges + "/" + referenceNotes.lessons + "/" + referenceNotes.titles;
        }

        public static String getFullLectionReference(Integer id){
            return  referenceNotes.challenges + "/" + referenceNotes.lessons + "/" + referenceNotes.full + "/" + id.toString();
        }

        public static String getFullQuizTitleReference(){
            return referenceNotes.challenges + "/" +referenceNotes.quizzes + "/"+ referenceNotes.titles;
        }

        public static String getFullQuizReference(Integer questionId){
            return referenceNotes.challenges + "/" + referenceNotes.quizzes + "/" + referenceNotes.full + "/" + questionId.toString();
        }

        public static String getAchievementsReference(String username){
            return referenceNotes.achievements + "/" + username;
        }

        public static String getLessonReedReference(String username,String lessonId){
            return getAchievementsReference(username) + "/" + lesson + lessonId + "/" + referenceNotes.isAchieved;
        }
    }
}