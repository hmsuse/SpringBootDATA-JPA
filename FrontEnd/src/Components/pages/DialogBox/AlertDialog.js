import React,{Component} from 'react';  
import { ProgressSpinner } from 'primereact/progressspinner'; 
import { connect } from 'react-redux'; 
import { Dialog } from 'primereact/dialog';
import { Button } from 'primereact/button'; 
class AlertDialog extends Component{
    constructor(props){
        super(props)
        this.state={ 
        }
    } 
   
    render(){ 
     const renderFooter =
             (
                <div>
                     <button className='btn btn-danger' onClick={this.props.onHide}>No</button>
                 <button className='btn btn-primary' onClick={this.props.isOk}>Yes</button> 
                </div>
            );
        const{isVisible,onHide,DialogBody,header,responseMsg,responseStatus,isOk}=this.props; 
        return(
            <div className=''>
             <Dialog header={header} visible={isVisible} footer={renderFooter}  style={{ width: '50vw' }} onHide={onHide}>
          <div className=''>{responseMsg}</div>
            </Dialog>

            </div>
        )
    }
} 
export default AlertDialog;