package com.example.bargiyora.server_api;

import com.example.bargiyora.model.BusinessCategory;
import com.example.bargiyora.model.Messages;
import com.example.bargiyora.model.Site;
import com.example.bargiyora.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerRequestHandler {

    public static void loginUser(String phone, String password, IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<User>> call = ClientApi.getServerApi().loginUser(phone, password);
        call.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(Call<BaseResponse<User>> call, Response<BaseResponse<User>> response) {
                if (iOnServerRequestListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse baseResponse = response.body();
                        iOnServerRequestListener.onSuccess(baseResponse);
                    } else {
                        iOnServerRequestListener.onFailure();
                    }
                }
            }
            @Override
            public void onFailure(Call<BaseResponse<User>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }

    public static void addUser(AddUserRequest addUserRequest, IOnServerRequestListener iOnServerRequestListener){
        if(addUserRequest != null){
            Call<BaseResponse<Integer>> call= ClientApi.getServerApi().addUser(addUserRequest);
            call.enqueue(new Callback<BaseResponse<Integer>>() {
                @Override
                public void onResponse(Call<BaseResponse<Integer>> call, Response<BaseResponse<Integer>> response) {
                    if (iOnServerRequestListener != null) {
                        if (response.isSuccessful() && response.body() != null) {
                            BaseResponse baseResponse = response.body();
                            iOnServerRequestListener.onSuccess(baseResponse);
                        } else {
                            iOnServerRequestListener.onFailure();
                        }
                    }
                }
                @Override
                public void onFailure(Call<BaseResponse<Integer>> call, Throwable t) {
                    if (iOnServerRequestListener != null) {
                        iOnServerRequestListener.onFailure();
                    }
                }
            });
        }
    }


    public static void changePassword(String newPassword, String oldPassword, String id, IOnServerRequestListener iOnServerRequestListener){
        Call<BaseResponse<Integer>> call=ClientApi.getServerApi().changePassword(newPassword, oldPassword, id);
        call.enqueue(new Callback<BaseResponse<Integer>>() {
            @Override
            public void onResponse(Call<BaseResponse<Integer>> call, Response<BaseResponse<Integer>> response) {
                if (iOnServerRequestListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse baseResponse = response.body();
                        iOnServerRequestListener.onSuccess(baseResponse);
                    } else {
                        iOnServerRequestListener.onFailure();
                    }
                }
            }
            @Override
            public void onFailure(Call<BaseResponse<Integer>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }

    public static void changeEmail(String id, String password, String newEmail, String oldEmail, IOnServerRequestListener iOnServerRequestListener){
        Call<BaseResponse<Integer>> call= ClientApi.getServerApi().changeEmail(id,password,newEmail,oldEmail);
        call.enqueue(new Callback<BaseResponse<Integer>>() {
            @Override
            public void onResponse(Call<BaseResponse<Integer>> call, Response<BaseResponse<Integer>> response) {
                if (iOnServerRequestListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse baseResponse = response.body();
                        iOnServerRequestListener.onSuccess(baseResponse);
                    } else {
                        iOnServerRequestListener.onFailure();
                    }
                }
            }
            @Override
            public void onFailure(Call<BaseResponse<Integer>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }



    public static void getMessageList(final IOnServerRequestListener iOnServerRequestListener) {
        ClientApi.getServerApi().getMessageList().enqueue(new Callback<BaseResponse<List<Messages>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Messages>>> call, Response<BaseResponse<List<Messages>>> response) {
                if (iOnServerRequestListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse baseResponse = response.body();
                        iOnServerRequestListener.onSuccess(baseResponse);
                    } else {
                        iOnServerRequestListener.onFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Messages>>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }

    public static void deleteMessage(DeleteMessageRequest deleteMessageRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (deleteMessageRequest != null) {
            Call<BaseResponse<Integer>> call = ClientApi.getServerApi().deleteMessage(deleteMessageRequest);
            call.enqueue(new Callback<BaseResponse<Integer>>() {
                @Override
                public void onResponse(Call<BaseResponse<Integer>> call, Response<BaseResponse<Integer>> response) {
                    if (iOnServerRequestListener != null) {
                        if (response.isSuccessful() && response.body() != null) {
                            BaseResponse baseResponse = response.body();
                            iOnServerRequestListener.onSuccess(baseResponse);
                        } else {
                            iOnServerRequestListener.onFailure();
                        }
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse<Integer>> call, Throwable t) {
                    if (iOnServerRequestListener != null) {
                        iOnServerRequestListener.onFailure();
                    }
                }
            });
        }
    }

    public static void addMessage(Messages message, IOnServerRequestListener iOnServerRequestListener){
        if(message != null){
            Call<BaseResponse<Messages>> call =ClientApi.getServerApi().addMessage(message);
            call.enqueue(new Callback<BaseResponse<Messages>>() {
                @Override
                public void onResponse(Call<BaseResponse<Messages>> call, Response<BaseResponse<Messages>> response) {
                    if (iOnServerRequestListener != null) {
                        if (response.isSuccessful() && response.body() != null) {
                            BaseResponse baseResponse = response.body();
                            iOnServerRequestListener.onSuccess(baseResponse);
                        } else {
                            iOnServerRequestListener.onFailure();
                        }
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse<Messages>> call, Throwable t) {
                    if (iOnServerRequestListener != null) {
                        iOnServerRequestListener.onFailure();
                    }
                }
            });
        }
    }



    public static void getSitesByCategoryId(String categoryId, IOnServerRequestListener iOnServerRequestListener){
        Call<BaseResponse<List<Site>>> call = ClientApi.getServerApi().getSitesByCategoryId(categoryId);
        call.enqueue(new Callback<BaseResponse<List<Site>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Site>>> call, Response<BaseResponse<List<Site>>> response) {
                if (iOnServerRequestListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse baseResponse = response.body();
                        iOnServerRequestListener.onSuccess(baseResponse);
                    } else {
                        iOnServerRequestListener.onFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Site>>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }

    public static void getBusinessCategoryList(IOnServerRequestListener iOnServerRequestListener){
        Call<BaseResponse<List<BusinessCategory>>> call= ClientApi.getServerApi().getBusinessCategoryList();
        call.enqueue(new Callback<BaseResponse<List<BusinessCategory>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<BusinessCategory>>> call, Response<BaseResponse<List<BusinessCategory>>> response) {
                if (iOnServerRequestListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse baseResponse = response.body();
                        iOnServerRequestListener.onSuccess(baseResponse);
                    } else {
                        iOnServerRequestListener.onFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<BusinessCategory>>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }
}
