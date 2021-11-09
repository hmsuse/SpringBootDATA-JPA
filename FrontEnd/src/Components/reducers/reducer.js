import Types from "../actions/action-types";

const initialState = {
    isLoading: false,
    items: [],
    hasError: false
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
       default:
          return state;
    }
 }
 export default reducers;