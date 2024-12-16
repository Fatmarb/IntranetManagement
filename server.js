const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const { Document, Favorite } = require('./models');

const app = express();
app.use(cors());
app.use(bodyParser.json());

// Create Document
app.post('/documents', async (req, res) => {
    const { title, content, authorId, departmentId, visibility } = req.body;
    try {
        const document = await Document.create({ title, content, authorId, departmentId, visibility });
        res.status(201).json(document);
    } catch (err) {
        res.status(500).json({ error: 'Failed to create document' });
    }
});

// More routes here...

app.listen(3307, () => console.log('Server running on http://localhost:3307'));
