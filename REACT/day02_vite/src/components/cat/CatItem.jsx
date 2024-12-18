import React from 'react';

const CatItem = ({item}) => {
    const {id, img, title} = item;
    
    return (
        <div>
            <a href='#'>
                <div>
                    <img src={ img } alt = {title } />  
                </div> 
            </a>
        </div>           
    );
};

export default CatItem;