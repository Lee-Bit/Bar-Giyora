package com.example.bargiyora.server_api;

import com.example.bargiyora.model.Business;
import com.example.bargiyora.model.BusinessCategory;
import com.example.bargiyora.model.DeliveryAndSale;
import com.example.bargiyora.model.Messages;
import com.example.bargiyora.model.Request;
import com.example.bargiyora.model.Site;
import com.example.bargiyora.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerRequestHandler {

    public static void loginUser(String phone, String password, IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<User>> call = ClientApi.getServerApi().loginUser(phone, password);
        createCallbackListener(call, iOnServerRequestListener);
        /*
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

         */
    }

    public static void addUser(AddUserRequest addUserRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (addUserRequest != null) {
            Call<BaseResponse<Integer>> call = ClientApi.getServerApi().addUser(addUserRequest);
            createCallbackListener(call, iOnServerRequestListener);
            /*
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

             */
        }
    }


    public static void changePassword(ChangePasswordRequest changePasswordRequest, IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<Integer>> call = ClientApi.getServerApi().changePassword(changePasswordRequest);
        createCallbackListener(call, iOnServerRequestListener);
        /*
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
         */
    }

    public static void changeEmail(ChangeEmailRequest changeEmailRequest, IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<Integer>> call = ClientApi.getServerApi().changeEmail(changeEmailRequest);
        createCallbackListener(call, iOnServerRequestListener);
        /*
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

         */
    }


    public static void getMessageList(final IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<List<Messages>>> call = ClientApi.getServerApi().getMessageList();
        createCallbackListener(call, iOnServerRequestListener);
        /*
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

         */
    }

    public static void deleteMessage(DeleteMessageRequest deleteMessageRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (deleteMessageRequest != null) {
            Call<BaseResponse<Integer>> call = ClientApi.getServerApi().deleteMessage(deleteMessageRequest);
            createCallbackListener(call, iOnServerRequestListener);
            /*
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

             */
        }
    }

    public static void addMessage(Messages message, IOnServerRequestListener iOnServerRequestListener) {
        if (message != null) {
            Call<BaseResponse<Messages>> call = ClientApi.getServerApi().addMessage(message);
            createCallbackListener(call, iOnServerRequestListener);
            /*
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

             */
        }
    }


    public static void getSitesByCategoryId(String categoryId, IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<List<Site>>> call = ClientApi.getServerApi().getSitesByCategoryId(categoryId);
        createCallbackListener(call, iOnServerRequestListener);
        /*
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

         */
    }

    public static void deleteSite(DeleteSiteRequest deleteSiteRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (deleteSiteRequest != null) {
            Call<BaseResponse<Integer>> call = ClientApi.getServerApi().deleteSite(deleteSiteRequest);
            createCallbackListener(call, iOnServerRequestListener);
        }
    }

    public static void addSite(AddSiteRequest addSiteRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (addSiteRequest != null) {
            Call<BaseResponse<Site>> call = ClientApi.getServerApi().addSite(addSiteRequest);
            createCallbackListener(call, iOnServerRequestListener);
        }
    }


    public static void getItemList(IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<List<DeliveryAndSale>>> call = ClientApi.getServerApi().getItemList();
        createCallbackListener(call, iOnServerRequestListener);
    }

    public static void addItem(DeliveryAndSale deliveryAndSale, IOnServerRequestListener iOnServerRequestListener) {
        if (deliveryAndSale != null) {
            Call<BaseResponse<DeliveryAndSale>> call = ClientApi.getServerApi().addItem(deliveryAndSale);
            createCallbackListener(call, iOnServerRequestListener);
        }
    }

    public static void deleteItem(DeleteDeliveryAndSaleRequest deleteDeliveryAndSaleRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (deleteDeliveryAndSaleRequest != null) {
            Call<BaseResponse<Integer>> call = ClientApi.getServerApi().deleteItem(deleteDeliveryAndSaleRequest);
            createCallbackListener(call, iOnServerRequestListener);
        }
    }

//    public static void updateItem(DeliveryAndSale deliveryAndSale, IOnServerRequestListener iOnServerRequestListener){
//        if(deliveryAndSale != null){
//            Call<BaseResponse<DeliveryAndSale>> call= ClientApi.getServerApi().updateItem(deliveryAndSale);
//            createCallbackListener(call,iOnServerRequestListener);
//        }
//    }


    public static void getBusinessCategoryList(IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<List<BusinessCategory>>> call = ClientApi.getServerApi().getBusinessCategoryList();
        createCallbackListener(call, iOnServerRequestListener);
        /*
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
        */
    }

    public static void getBusinessByCategory(String categoryId, IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<List<Business>>> call = ClientApi.getServerApi().getBusinessByCategory(categoryId);
        createCallbackListener(call, iOnServerRequestListener);
    }

    public static void deleteBusiness(DeleteBusinessRequest deleteBusinessRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (deleteBusinessRequest != null) {
            Call<BaseResponse<Integer>> call = ClientApi.getServerApi().deleteBusiness(deleteBusinessRequest);
            createCallbackListener(call, iOnServerRequestListener);
        }
    }

    public static void addBusiness(AddBusinessRequest addBusinessRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (addBusinessRequest != null) {
            Call<BaseResponse<Business>> call = ClientApi.getServerApi().addBusiness(addBusinessRequest);
            createCallbackListener(call, iOnServerRequestListener);
        }
    }


    public static void getRequestList(String userId, IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<List<Request>>> call = ClientApi.getServerApi().getRequestList(userId);
        createCallbackListener(call, iOnServerRequestListener);
    }

    public static void updateStatus(UpdateStatusRequest updateStatusRequest, IOnServerRequestListener iOnServerRequestListener) {
        if (updateStatusRequest != null) {
            Call<BaseResponse<Request>> call = ClientApi.getServerApi().updateStatus(updateStatusRequest);
            createCallbackListener(call, iOnServerRequestListener);
        }
    }

    public static void addRequest(Request request, IOnServerRequestListener iOnServerRequestListener) {
        if (request != null) {
            Call<BaseResponse<Request>> call = ClientApi.getServerApi().addRequest(request);
            createCallbackListener(call, iOnServerRequestListener);
        }
    }


    private static <T> void createCallbackListener(Call<BaseResponse<T>> call, IOnServerRequestListener iOnServerRequestListener) {
        call.enqueue(new Callback<BaseResponse<T>>() {
            @Override
            public void onResponse(Call<BaseResponse<T>> call, Response<BaseResponse<T>> response) {
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
            public void onFailure(Call<BaseResponse<T>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }
}
