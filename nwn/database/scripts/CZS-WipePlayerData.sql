

BEGIN TRANSACTION 

DELETE FROM dbo.ChatLog

DELETE FROM dbo.ConstructionSites 

DELETE FROM dbo.ForcedSPResetDates

DELETE FROM dbo.PCAbilityCooldowns 

DELETE FROM dbo.PCAuthorizedCDKeys

DELETE FROM dbo.PCBadges

DELETE FROM dbo.PCBlueprints

DELETE FROM dbo.PCCorpseItems

DELETE FROM dbo.PCCorpses

DELETE FROM dbo.PCCrafts

DELETE FROM dbo.PCCustomEffects

DELETE FROM dbo.PCEquippedAbilities

DELETE FROM dbo.PCKeyItems

DELETE FROM dbo.PCLearnedAbilities

DELETE FROM dbo.PCMigrationItems

DELETE FROM dbo.PCMigrations

DELETE FROM dbo.PCOutfits

DELETE FROM dbo.PCOverflowItems

DELETE FROM dbo.PCSearchSiteItems

DELETE FROM dbo.PCSearchSites

DELETE FROM dbo.PCTerritoryFlagsStructuresResearchQueues

DELETE FROM dbo.PCTerritoryFlagsStructuresItems

DELETE FROM dbo.PCTerritoryFlagsPermissions

DELETE FROM dbo.PCTerritoryFlagsStructures

DELETE FROM dbo.PCTerritoryFlags

DELETE FROM dbo.PlayerProgressionSkills

DELETE FROM dbo.PlayerCharacters

DELETE FROM dbo.StorageItems
 

 

-- rollback
-- commit