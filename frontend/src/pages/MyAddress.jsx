import React, { useState } from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import './MyAddress.css';
import PrimaryButton from '../components/PrimaryButton';

const MyAddress = () => {
    const [isEditing, setIsEditing] = useState(false);
    const [country, setCountry] = useState('');
    const [postalCode, setPostalCode] = useState('');
    const [city, setCity] = useState('');
    const [street, setStreet] = useState('');
    const [houseNumber, setHouseNumber] = useState('');

    const handleEditClick = () => {
        setIsEditing(true);
    };

    const handleSaveClick = () => {
        setIsEditing(false);
        // Tutaj możesz dodać logikę do zapisu danych
    };

    return (
        <div className="con">
            <Navbar />
            <div className="address-container">
                <div className="quote">
                    <p>My Address</p>
                </div>
                <div className="edit-button">
                    <PrimaryButton color="blue" onClick={handleEditClick}>Edit</PrimaryButton>
                </div>
                <div className="address-container-2">
                    <div className="address-box">
                        Country: {isEditing ? <input className="input-edit" type="text" value={country} onChange={(e) => setCountry(e.target.value)} /> : country}
                    </div>
                    <div className="address-box">
                        Postal Code: {isEditing ? <input className="input-edit" type="text" value={postalCode} onChange={(e) => setPostalCode(e.target.value)} /> : postalCode}
                    </div>
                    <div className="address-box">
                        City: {isEditing ? <input className="input-edit" type="text" value={city} onChange={(e) => setCity(e.target.value)} /> : city}
                    </div>
                    <div className="address-box">
                        Street: {isEditing ? <input className="input-edit" type="text" value={street} onChange={(e) => setStreet(e.target.value)} /> : street}
                    </div>
                    <div className="address-box">
                        House number/Flat: {isEditing ? <input className="input-edit" type="text" value={houseNumber} onChange={(e) => setHouseNumber(e.target.value)} /> : houseNumber}
                    </div>
                </div>
                {isEditing && <PrimaryButton color="blue" onClick={handleSaveClick}>Save</PrimaryButton>}
            </div>
            
            <Footer />
        </div>
    );
}

export default MyAddress;
