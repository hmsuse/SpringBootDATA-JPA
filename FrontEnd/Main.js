import React,{Component, Fragment} from 'react'  
import { BrowserRouter as Router, Route, Link ,Redirect, Switch, withRouter} from "react-router-dom";
import Login from './src/Components/Auth/Login';
import { connect } from 'react-redux';
import UsersList from './src/Components/pages/usersList';
import Header from './src/Components/pages/Header/Header';
import Footer from './src/Components/pages/Footer/Footer';
import Resume from './src/Components/pages/Resume/Resume';
import Guest from './src/Components/pages/Guestes/Guest'; 
import FloorsList from './src/Components/pages/Floor/Floors';
 const Main=(props)=>{ 
return( 
        <div>
         
        <Switch> 
        <Router> 
        {sessionStorage.userName?<Header/>:''}     
           <Route  path='/' exact component={Login}/>
           <Route path='/users' component={UsersList}/>
           
           <Route path='/floors' component={FloorsList}/>
           {/* <Route path='/resume' component={Resume}/> */}
           <Route path='/guests' component={Guest}/>
        </Router>
        </Switch>  
        {sessionStorage.userName? <Footer/>:''} 
        </div>
);
 }
 const mapStateToProps=(state)=>({

 })
 export default connect(mapStateToProps,'')(Main);