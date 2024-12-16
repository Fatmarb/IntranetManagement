module.exports = (sequelize, DataTypes) => {
    const Document = sequelize.define('Document', {
        title: { type: DataTypes.STRING, allowNull: false },
        content: { type: DataTypes.TEXT, allowNull: false },
        authorId: { type: DataTypes.INTEGER, allowNull: false },
        departmentId: { type: DataTypes.INTEGER, allowNull: false },
        visibility: { type: DataTypes.ENUM('public', 'private'), defaultValue: 'public' },
        highlighted: { type: DataTypes.BOOLEAN, defaultValue: false },
    });
    return Document;
};
