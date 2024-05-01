import React from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import PrimaryButton from '../components/PrimaryButton';
import CategoryItem from '../components/CategoryItem';
import './ChooseCategory.css'; // Zaimportuj plik ze stylami
import cupcakes from '../assets/cupcakes_category.svg';
import cake from '../assets/cake_category.svg';
import donuts from '../assets/donuts_category.svg';
import cookies from '../assets/cookies_category.svg';

const ChooseCategory = () => {
    return (
        <div className="con">
            <Navbar />
            <main className="chooseCategory-container">
                <h1 className="quote">Choose category</h1>
                <div className="category-container" id="category-container">
                    <CategoryItem imgSrc={cupcakes} text="Cupcakes" />
                    <CategoryItem imgSrc={cake}  text="Cakes" />
                    <CategoryItem imgSrc={donuts}  text="Donuts" />
                    <CategoryItem imgSrc={cookies}  text="Cookies" />
                </div>
                <PrimaryButton type="button" color="blue" >Next</PrimaryButton>
            </main>
            <Footer />
        </div>
    );
}

export default ChooseCategory;