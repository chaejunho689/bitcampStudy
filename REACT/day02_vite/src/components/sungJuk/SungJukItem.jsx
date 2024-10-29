import React from 'react';

const SungJukItem = (item) => {
    const {seq, name, kor, eng, math} = item;
    const total = kor + math + eng;
    const avg = (total / 3);
    return (
        <div>
            <tr>
                <td>{seq}</td>
                <td>{name}</td>
                <td>{kor}</td>
                <td>{eng}</td>
                <td>{math}</td>
                <td>{total}</td>
                <td>{avg}</td>
            </tr>
        </div>
    );
};

export default SungJukItem;