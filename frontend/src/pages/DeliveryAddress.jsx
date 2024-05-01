import React from 'react';
import './DeliveryAddress.css'; 
import Input from '../components/Input'; 
import PrimaryButton from '../components/PrimaryButton';
import Checkbox from '../components/Checkbox';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';

function DeliveryAddress() {
    return (
        <div className="con">
            <Navbar />
            <div className="delivery-container">
                <h1 className="quote">Delivery address</h1>
                <Checkbox id="myAddress" label="My Address" value="myAddress" />
                <div className="separator-container">
                    <hr className="separator" />
                    <div className="separator-text">or</div>
                    <hr className="separator" />
                </div>
                <Checkbox id="customAddress" label="Custom Address" value="customAddress" />
                <form className="addressForm" method="POST">
                    <Input name="country" type="text" placeholder="country" />
                    <Input name="postcode" type="text" placeholder="postcode" />
                    <Input name="city" type="text" placeholder="city" />
                    <Input name="street" type="text" placeholder="street" />
                    <Input name="number" type="text" placeholder="number" />
                </form>
                <PrimaryButton type="button" color="blue" redirectTo="/success">Send</PrimaryButton>
                <Footer />
            </div>
            
        </div>
    );
}

export default DeliveryAddress;
