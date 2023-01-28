package com.example.hostelappnitj;

import android.provider.SyncStateContract;

import com.example.hostelappnitj.ModelResponse.CreateProfileResponse;
import com.example.hostelappnitj.ModelResponse.DataModel;
import com.example.hostelappnitj.ModelResponse.HostelRegisterationResponse;
import com.example.hostelappnitj.ModelResponse.RegisterResponse;
import com.example.hostelappnitj.ModelResponse.hostel;
import com.example.hostelappnitj.ModelResponse.hostel_ID_Response;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Api {
    //  FOR REGISTERING USER
    @POST("Signup")
    Call<DataModel> register(
            @Body DataModel dataModel);
//
//    //    for LOGIN user
    @POST("login")
    Call<DataModel>login(
            @Body DataModel dataModel);

//    for uploading image
    @Multipart
    @POST("uploadProfile/{id}")
    Call<RegisterResponse>UploadProfile(
            @Path("id")String id,
            @Part MultipartBody.Part photo
    );

    //    //      FOR FETCHING ALL THE HOSTELS
    @GET("hostelbook/getHostels")
    Call<HostelRegisterationResponse>fetchAllHostels();


//    @Multipart
    @POST("hostelbook/registerRoom")   //since we are sending the paramter in the path with id (so we use @PATH)
    Call<HostelRegisterationResponse>updateHostelRecord(
//            @Part MultipartBody.Part pdf,
@Body HostelRegisterationResponse hostelRegisterationResponse
//            @Field ("userName") String userName,
//            @Field ("roomNumber") String roomNumber,
//            @Field ("email") String email,
//            @Field("rollNumber")String rollNumber
            );

//    @Multipart
//    @POST("XXXX")
//    Call<HostelRegisterationResponse> update(@Part(SyncStateContract.Constants.ACTION_ID) RequestBody actionId, @Part(Constants.OFFER_CODE) RequestBody offerCode);



//    @Multipart
//    @POST("uploadProfile/{id}")
//    Call<RegisterResponse>UploadProfile(
//            @Path("id")String id,
//            @Part MultipartBody.Part photo
//    );


//
//@GET("hostel_booking/BookHostel/{roomNumber}")  //to get the id of the particular room number
//Call<hostel_ID_Response> getHostelId(
//        @Path("roomNumber") String hostel_id
//);

//
//
//
//        MAKE SURE THE PARAMTER IN { } MUST MATCHES WITH THAT PASSED IN API   /:id
    @PUT("{id}")   //since we are sending the paramter in the path with id (so we use @PATH)
    Call<CreateProfileResponse>createUserProfile(
            @Path("id") String user_id,
            @Body CreateProfileResponse createProfileResponse
    );

//
//    //    to update the password from user USE PUT
//    @PUT("password/{id}")
//    Call<UpdateUserResponse>updatePassword(
//            @Path("id")String user_id,
//            @Body UpdateUserResponse updateUserResponse
//    );
//
//    //    To delete the account
//    @DELETE("{id}")
//    Call<RegisterResponse>deleteuser(
//            @Path("id")  String user_id);
//
//    //to update the image on the server  //USING HASHMAP
//    @Multipart
//    @POST("uploadProfile/{id}")
//    Call<RegisterResponse>UploadProfile(
//            @Path("id")String id,
//            @Part MultipartBody.Part photo
//    );
//
//    @DELETE("deleteProfile/{id}")
//    Call<RegisterResponse>deleteProfile(
//            @Path("id") String id ,
//            @Query("imageURL") String imageURL
//    );
}