import Types from "../actions/action-types";

const initialState = {
    isLoading: false,
    items: [],
    hasError: false,
    geteditUser:{userName:'',firstName:'',lastName:'',userType:'',email:'',phoneNo:''},
    addUserStatus:'',
    addUserMsg:''
 };
 const reducers = (state = initialState, action) => { //es6 arrow function
    switch (action.type) {
       case 'LOGIN_SUCCESS': 
       console.log(action.payload)
       if(action.payload.status=='success'){
         sessionStorage.userName=action.payload.data.userName
         window.location.href='/users'
       } 
          return  {
             ...state
          }
         case Types.GET_USERS_LIST:
             console.log(action.payload)
             return{
                ...state,
                getUsersDetails:action.payload
             }
         case Types.ADD_AND_UPDATE_FLOOR_LIST:
            return{
               ...state, 
                }
         case Types.ADD_AND_UPDATE_USER:
            console.log(action);
            return{
                ...state,
               addUserStatus:action.payload.status,
               addUserMsg:action.payload.msg
                  }
         case Types.EDIT_USER: 
            return{
               ...state,
               geteditUserDetails:action.res
                  }
         case Types.DELETE_USER:
            return{
               ...state,
               deleteUserStatus:action.payload.status,
               deleteUserMsg:action.payload.msg
                  }
         case Types.CREATE_USER:
            return{
               ...state,
               geteditUserDetails:state.geteditUser
                  }
         case Types.NULLIFY_SERVICE:
            return{
               ...state,
               addUserStatus:'',
               addUserMsg:'',
               deleteUserStatus:'',
               deleteUserMsg:''
                  }
       default:
          return state;
    }
 }
 export default reducers;