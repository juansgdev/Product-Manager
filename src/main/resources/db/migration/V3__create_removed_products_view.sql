CREATE VIEW vw_removed_products AS
SELECT *
FROM products
WHERE status = 'INACTIVE';
