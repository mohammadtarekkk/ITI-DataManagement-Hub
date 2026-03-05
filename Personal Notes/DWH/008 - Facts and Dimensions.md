# Facts and Dimensions

Dimensional modeling separates data into two types:

## Facts (Measures)
- **Quantitative** data that can be counted or aggregated.
- Typically numeric.
- Answers: "How much?", "How many?"
- **Examples**: `Sales Amount`, `Quantity Sold`, `Profit`, `Temperature`.

## Dimensions (Context)
- **Descriptive** attributes that provide context to the facts.
- **Qualitative** data.
- Answers: "Who?", "What?", "Where?", "When?"
- **Examples**: `Customer Name`, `Product Category`, `Store Location`, `Date`.

## Interaction
- You analyze **Facts** by slicing them through **Dimensions**.
- *Example*: "Show me `Sales Amount` (Fact) by `Product Category` (Dimension) in `2023` (Dimension/Date)."

## Related
- [[007 - Relational vs Dimensional Modeling]]
- [[016 - Fact Types]]
- [[012 - Dimension Types]]
