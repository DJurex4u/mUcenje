package com.example.muenje.data.network;

import com.example.muenje.data.network.pojo.FullLessonResponse;
import com.example.muenje.data.network.pojo.FullQuizResponse;
import com.example.muenje.data.network.pojo.LeaderboardResponse;
import com.example.muenje.data.network.pojo.LessonTitleResponse;
import com.example.muenje.data.network.pojo.QuizTitleResponse;
import com.example.muenje.data.network.pojo.SingleAchievementResponse;
import com.example.muenje.data.network.pojo.SingleLeaderboardEntryResponse;
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
                    ArrayList<LessonTitleResponse> lessonsTitlesArrayList = new ArrayList<>();
                    for (DataSnapshot dataSnapshotLessonTitles : dataSnapshot.getChildren()) {
                        lessonsTitlesArrayList.add(dataSnapshotLessonTitles.getValue(LessonTitleResponse.class));
                    }
                    return lessonsTitlesArrayList;
                }));
    }

    public Maybe<FullLessonResponse> getFullLesson(Integer id) {
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getFullLectionReference(id));
        return RxFirebaseDatabase.observeSingleValueEvent(query,
                (dataSnapshot -> dataSnapshot.getValue(FullLessonResponse.class)));
    }

    public Maybe<List<QuizTitleResponse>> getQuizTitles() {
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getFullQuizTitleReference());
        return RxFirebaseDatabase.observeSingleValueEvent(query, (dataSnapshot -> {
            ArrayList<QuizTitleResponse> quizTitlesArrayList = new ArrayList<>();
            for (DataSnapshot dataSnapshotQuizTitles : dataSnapshot.getChildren()) {
                quizTitlesArrayList.add(dataSnapshotQuizTitles.getValue(QuizTitleResponse.class));
            }
            return quizTitlesArrayList;
        }));
    }

    public Maybe<FullQuizResponse> getFullQuiz(Integer quizId) {
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getFullQuizReference(quizId));
        return RxFirebaseDatabase.observeSingleValueEvent(query, FullQuizResponse.class);
    }

    public Maybe<List<SingleAchievementResponse>> getUsersAchievements(String username) {
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getAchievementsReference(username));
        return RxFirebaseDatabase.observeSingleValueEvent(query, (dataSnapshot -> {
            ArrayList<SingleAchievementResponse> achievementResponseArrayList = new ArrayList<>();
            for (DataSnapshot dataSnapshotSingleAchievement : dataSnapshot.getChildren()) {
                achievementResponseArrayList.add(dataSnapshotSingleAchievement.getValue(SingleAchievementResponse.class));
            }
            return achievementResponseArrayList;
        }));
    }

    public void setLessonRed(String username, String lessonId) {
        mFirebaseDatabase
                .getReference(referenceNotes.getLessonRedReference(username, lessonId))
                .setValue(true);
    }

    public void setQuizSolved(String username, String quizId) {
        mFirebaseDatabase
                .getReference(referenceNotes.getQuizSolvedReference(username, quizId))
                .setValue(true);
    }

    public void setLessonRedAchievementDisplayName(String username, String lessonId) {
        mFirebaseDatabase
                .getReference(referenceNotes.getLessonAchievementDisplayNameReference(username,lessonId))
                .setValue(AchievementNotes.getAchievementDisplayName(AchievementReason.LESSON, lessonId));
    }

    public void setQuizSolvedAchievementDisplayName(String username, String quizId) {
        mFirebaseDatabase
                .getReference(referenceNotes.getQuizAchievementsDisplayNameReference(username, quizId))
                .setValue(AchievementNotes.getAchievementDisplayName(AchievementReason.QUIZ, quizId));
    }

    public Maybe<LeaderboardResponse> getLeaderboard(){
        final Query query = mFirebaseDatabase.getReference(referenceNotes.getLeaderboardReference());
        return RxFirebaseDatabase.observeSingleValueEvent(query, (dataSnapshot -> {
            ArrayList<SingleLeaderboardEntryResponse> singleLeaderboardEntryResponsesList = new ArrayList<>();
            for(DataSnapshot singleLeaderboardEntryResponseDataSnapshot : dataSnapshot.getChildren()){
                singleLeaderboardEntryResponsesList.add(extractSingleLeaderboardEntryResponse(singleLeaderboardEntryResponseDataSnapshot));
            }
            return new LeaderboardResponse(singleLeaderboardEntryResponsesList);
        }));
    }

    private SingleLeaderboardEntryResponse extractSingleLeaderboardEntryResponse(DataSnapshot singleLeaderboardEntryResponseDataSnapshot){
        String key = singleLeaderboardEntryResponseDataSnapshot.getKey();
        Integer value = singleLeaderboardEntryResponseDataSnapshot.getValue(Integer.class);
        return new SingleLeaderboardEntryResponse(key,value);
    }

    private static class referenceNotes {
        final static String challenges = "challenges";
        final static String lessons = "lessons";
        final static String quizzes = "quizzes";
        final static String titles = "titles";
        final static String full = "full";

        public final static String displayName = "displayName";
        final static String achievements = "achievements";
        final static String lesson = "lesson";
        final static String quiz = "quiz";
        final static String isAchieved = "isAchieved";

        final static String leaderboard = "leaderboard";

        public static String getLectionTitleReference() {
            return referenceNotes.challenges + "/" + referenceNotes.lessons + "/" + referenceNotes.titles;
        }

        public static String getFullLectionReference(Integer id) {
            return referenceNotes.challenges + "/" + referenceNotes.lessons + "/" + referenceNotes.full + "/" + id.toString();
        }

        public static String getFullQuizTitleReference() {
            return referenceNotes.challenges + "/" + referenceNotes.quizzes + "/" + referenceNotes.titles;
        }

        public static String getFullQuizReference(Integer questionId) {
            return referenceNotes.challenges + "/" + referenceNotes.quizzes + "/" + referenceNotes.full + "/" + questionId.toString();
        }

        public static String getAchievementsReference(String username) {
            return referenceNotes.achievements + "/" + username;
        }

        public static String getLessonRedReference(String username, String lessonId) {
            return getAchievementsReference(username) + "/" + lesson + lessonId + "/" + referenceNotes.isAchieved;
        }

        public static String getQuizSolvedReference(String username, String quizId) {
            return getAchievementsReference(username) + "/" + quiz + quizId + "/" + isAchieved;
        }

        public static String getLessonAchievementDisplayNameReference(String username, String lessonId) {
            return getAchievementsReference(username) + "/" + lesson + lessonId + "/" + referenceNotes.displayName;
        }

        public static String getQuizAchievementsDisplayNameReference(String username, String quizId) {
            return getAchievementsReference(username) + "/" + quiz + quizId + "/" + displayName;
        }

        public static String getLeaderboardReference(){
            return leaderboard;
        }

    }

    enum AchievementReason {
        LESSON,
        QUIZ
    }

    private static class AchievementNotes {
        final static ArrayList<String> lessons = new ArrayList<String>(){
            {
                add("Znamo više o Trenku!");
                add("Pročitali smo o Atomu!");
                add("Mravi više nisu nevidljivi!");
                add("Znamo sve o Trenku!");
            }
        };

        final static ArrayList<String> quizzes = new ArrayList<String>(){
            {
                add("Znamo sve o Trenku!");
                add("Znamo sve o Atomu!");
                add("Znamo sve o Mravima!");
            }
        };

        public static String getAchievementDisplayName(AchievementReason achievementReason, String id) {
            Integer mId = Integer.valueOf(id);
            switch (achievementReason){
                case QUIZ: return getQuizDisplayName(mId);
                case LESSON: return getLessonDisplayName(mId);
                default:
                    throw new IllegalStateException("Unexpected value: " + achievementReason);
            }
        }

        private static String getLessonDisplayName(Integer id) {
            return AchievementNotes.lessons.get(id);
        }

        private static String getQuizDisplayName(Integer id) {
            return AchievementNotes.quizzes.get(id);
        }
    }
}