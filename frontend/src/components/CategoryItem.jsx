import React from 'react';
import './CategoryItem.css'; // Zaimportuj plik ze stylami

const CategoryItem = ({ imgSrc, text }) => {
    return (
        <div className="category-item">
            <img className="categoryImg" src={imgSrc} alt={text} />
            <div className="checkbox-item">
                <input name="choose" type="radio" value={text.toLowerCase()} />
                <p>{text}</p>
            </div>
        </div>
    );
}

export default CategoryItem;