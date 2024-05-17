import React, { useState, useEffect } from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import './MyAddress.css';
import PrimaryButton from '../components/PrimaryButton';
import axios from '../../axiosConfig';

const MyAddress = () => {
    const [isEditing, setIsEditing] = useState(false);
    const [country, setCountry] = useState('');
    const [postcode, setPostalCode] = useState('');
    const [city, setCity] = useState('');
    const [street, setStreet] = useState('');
    const [number, setHouseNumber] = useState('');

    useEffect(() => {

        const fetchUserData = async () => {
            try {
                const response = await axios.get('/api/users/address', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`
                    }
                });
                const addressData = response.data;
                setCountry(addressData.country);
                setPostalCode(addressData.postcode);
                setCity(addressData.city);
                setStreet(addressData.street);
                setHouseNumber(addressData.number);
            } catch (error) {
                console.error('Error fetching user data:', error);
            }
        };
        fetchUserData();
    }, []);

    const handleEditClick = () => {
        setIsEditing(true);
    };

    const handleSaveClick = () => {
        setIsEditing(false);
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
                        Postal Code: {isEditing ? <input className="input-edit" type="text" value={postcode} onChange={(e) => setPostalCode(e.target.value)} /> : postcode}
                    </div>
                    <div className="address-box">
                        City: {isEditing ? <input className="input-edit" type="text" value={city} onChange={(e) => setCity(e.target.value)} /> : city}
                    </div>
                    <div className="address-box">
                        Street: {isEditing ? <input className="input-edit" type="text" value={street} onChange={(e) => setStreet(e.target.value)} /> : street}
                    </div>
                    <div className="address-box">
                        House number/Flat: {isEditing ? <input className="input-edit" type="text" value={number} onChange={(e) => setHouseNumber(e.target.value)} /> : number}
                    </div>
                </div>
                {isEditing && <PrimaryButton color="blue" onClick={handleSaveClick}>Save</PrimaryButton>}
            </div>

            <Footer />
        </div>
    );
}

export default MyAddress;
